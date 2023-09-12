import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallWorld {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        List<Integer> conquestSizes = findConquestSizes(matrix);
        Collections.sort(conquestSizes, Collections.reverseOrder());
        for (int size : conquestSizes) {
            System.out.println(size);
        }
    }

    private static boolean isValid(int x, int y, int[][] matrix, boolean[][] visited) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1 && !visited[x][y];
    }

    private static int dfs(int x, int y, int[][] matrix, boolean[][] visited) {
        visited[x][y] = true;
        int size = 1;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (isValid(newX, newY, matrix, visited)) {
                size += dfs(newX, newY, matrix, visited);
            }
        }

        return size;
    }

    private static List<Integer> findConquestSizes(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        boolean[][] visited = new boolean[N][M];
        List<Integer> conquestSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j, matrix, visited);
                    conquestSizes.add(size);
                }
            }
        }

        return conquestSizes;
    }
}

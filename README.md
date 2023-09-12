# Java_DSA_Small_World
Small World
Small World is fun board game about conquering the world by different fantasy races. Each race is defined by two interlocking tiles, one giving a noun describing the race (e.g., "Elves") and the other an adjective (e.g., "Flying"), describing an additional special ability or special scoring opportunity.

One of the skills defines that you can move and conquer only fields from same type (lawn, mountain, lakes) that are next to each other. On each turn the player with this race wants to take as many fields as possible.

Given a matrix of 1s (fields from one type that is allowed currently for the user) and 0s (other fields), calculate the size of each conquest.

А conquest is formed when each field is connected to another from same type either vertically or horizontally.
The size of a conquest is the number of conquered fields in it.
Input
Read from the standard input:

Line 1 - N M - dimensions of the matrix that represents the game board.
Next N lines - each of the rows in it.
Output
Print to the standard output:

Sizes of the conquests must be sorted in descending order.
Print each conquest's size on a new line.
Constraints
1 <= N, M <= 20

Sample Tests
Input
5 10
1000000010
1111000011
1000000000
1100001000
1000011100
Output
9
4
3
Input
4 4
0000
0110
0110
0000
Output
4

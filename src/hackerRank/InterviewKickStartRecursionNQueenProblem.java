package hackerRank;
import java.util.*;

/**
 n Queen Problem
 Given an integer n, find all the possible ways to position n queens on an n×n chessboard so that no two queens attack each other.
 A queen in chess can move horizontally, vertically, or diagonally.
 Do solve the problem using recursion first even if you see some non-recursive approaches.
 Example One
 Input: 4
 Output:
 [[
 "--q-",
 "q---",
 "---q",
 "-q--"
 ], [
 "-q--",
 "---q",
 "q---",
 "--q-"
 ]]
 There are two distinct ways four queens can be positioned on a 4×4 chessboard without attacking each other. The positions may appear in the output in any order. So the same two positions in different order would be another correct output.
 Example Two
 Input: 2
 Output: [ ]
 No way to position two queens on a 2×2 chessboard without them attacking each other - so empty array.
 Notes
 The function has one input argument: n.
 Output: The function must return a two-dimensional array of strings representing the arrangements. Size of the array must be m×n where m is the number of distinct arrangements. Length of each string must be n and the strings’ characters may be either ‘q’ (for a queen) or ‘-’ (for an empty position on the chessboard). Valid arrangements may appear in the output in any order.
 Constraints:
 1 <= n <= 12
 Custom Input
 Custom Input Format:
 First and only line of input contains integer n. For example:
 4
 Custom Output Format: For every one of m valid arrangements (if any), output must include n+1 lines - except the last one which must include only n lines. Of those n+1 lines first n must have n character each, representing rows of the chessboard; the last, (n+1)-th, line must be empty in every one of the m arrangements except the last one.
 Total number of lines in the output must be m*(n+1)-1.
 For input n=4 one correct output is:
 --q-
 q---
 ---q
 -q--
 -q--
 ---q
 q---
 --q-


 x	1	2	3 row	0	1	2	3
 0	1	x	x			0	1	2	3
 0	x	2	3			0	1	2	3
 0	1	2	3			0	1	2	3

            cols	0	1	2	3
 0	q	2	3		ldiag	0	1	2	3	4	5	6	7
 0	1	2	q		rdiag	0	1	2	3	4	5	6	7
 q	1	2	3
 0	1	q	3


 0	1	q	3
 q	1	2	3
 0	1	2	q
 0	q	2	3


 0	1	2	x
 x	x	2	3
 0	1	x	3
 0	1	2	3

 ALGORITHM:
 For a n*n dimensional array, check whether the queen can be placed in each of the columns in all the rows
 The queen can be successfully placed in a column only If that location is empty, it's left diagonal and the right diagonal is empty
 If the queen is successfully place in a column of the row, then another queen cannot be placed in the same row, hence, move on the the next row
 For the next row, check if a queen can be successfully placed in each of the columns by checking if it's row and column position is empty, and it's left and right diagonal is empty
 If a queen can be successfully placed in any column of a row, then, move on to the next row
 If a queen cannot be successfully placed in any of the columns of a particular row, then, it's not possible to place n queen in a n*n matrix since
 In that case, we have to revert back the placement of the queen in the previous location and continue checking if the queen can be placed in the next column of the preceeding placement
 Completet the above till all rows and columns are covered
 left diagonal = row + col
 right diagonal = row + col.length-1 - col
 Base case:
 If the row length == the board length, create a list/array of strings equal to the row length of the chess board array
 copy each row from the 2d char array to the string array
 add the string array to the results arraylist

 */

public class InterviewKickStartRecursionNQueenProblem {

    private static List<String[]> solutions = new ArrayList<String[]>();
    public static void main(String[] args) {

        int n = 4;
        //false means not selected
        boolean[] cols = new boolean[n];
        boolean[] lDiag = new boolean[(n*2)-1];
        boolean[] rDiag = new boolean[(n*2)-1];
        char[][] board = new char[n][n];

        for (char[] row: board) Arrays.fill(row,'-');

        solveBoard(board, 0, cols, lDiag, rDiag);


    }

    private static void solveBoard(char[][] board, int row, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {

        System.out.println("board length : " + board.length);
        System.out.println("Row : " + row);
        if (row == board.length) {

            String[] solvedBoard = new String[board.length];

            int solvedRow = 0;

            for (char[] currRow: board) {
                solvedBoard[solvedRow++] = String.valueOf(currRow);
            }

            solutions.add(solvedBoard);
            for ( String[] s : solutions ) {
                for ( String s1 : s ) {
                    System.out.println( "solutions : " + s1);
                }
            }

        } else {

            for (int col = 0; col < cols.length; col++) {
                System.out.println("Row :" + row + " Col : " + col) ;
                if (selectCol(row,col,cols,lDiag,rDiag)) {

                    board[row][col] = 'q';

                    System.out.println("Queen placed at row : " + row + " and col : " + col);
                    solveBoard(board,row + 1, cols, lDiag, rDiag);

                    board[row][col] = '-';
                    System.out.println("Queen removed at row : " + row + " and col : " + col);

                    deselectCol(row,col,cols,lDiag,rDiag);
                }
            }

        }
    }

    private static boolean selectCol(int row, int col, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {

            if (!cols[col] && ! lDiag[row + col] && !rDiag[row + cols.length-1 - col]) {
            cols[col] = true;
            lDiag[row + col] = true;
            rDiag[row + cols.length-1 - col] = true;
            return true;
        }
        else {
            return false;
        }
    }

    private static void deselectCol(int row, int col, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {
        cols[col] = false;
        lDiag[row + col] = false;
        rDiag[row + cols.length-1 - col] = false;
    }
}

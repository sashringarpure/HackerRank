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

    public static void main(String[] args)  {

//        FileReader fr = new FileReader("/Users/sshringarpure/IdeaProjects/Interview/src/input.txt");
//        BufferedReader br = new BufferedReader(fr);
//        String line = "";
//        HashMap<String, Integer> hm = new HashMap<String, Integer>();
//        while ( (line = br.readLine()) != null) {
//            if ( hm.containsKey(line) ) {}
//            else {
//                System.out.println(line);
//                hm.put(line,1);
//            }
//
//        }
//
//        assert line == "Hello";

    int rows = 0;
    int cols = 0;
    int n = 4;
    ArrayList<String> al = new ArrayList<String>();
    recursiveCall(rows, cols, n, al);
    }

    public static void recursiveCall(int row, int col, int n, ArrayList al) {
        if ( row == 0 && col == n ) {
            return;
        } else {
            while ( row < n && col < n) {
                int i = row+1;
                al.add(row+","+col);
                for (int j = 0; j < n ; j++) {
                    if ( canBeOccupied(i, j, al, n) ){
                        al.add(i+","+j);
                        if ( i == (n-1) ) {
                            break;
                        } else {
                            i = i + 1;
                            j = -1;
                        }
                    } else {
                        if ( al.size() != n && row == (n-1) && col == (n-1) ) {
                            al.clear();
                            break;
                        }
                        if ( i < (n-1) && j == (n-1) ) {
                            i = i+1;
                            j=-1;
                        }
                    }
                }
                col++;
                row=0;
                System.out.println(al);
                al.clear();
            }
        }
        recursiveCall(row,col,n, al);
    }

    public static boolean canBeOccupied(int i, int j, ArrayList<String> al, int n) {
      //same row check.
        int x=i;
        int y=j;
        while (x >= 0) {
            if ( al.contains(x+","+y)) return false;
            x--;
        }
     //Diagonal check - from left to right.
        x=i;
        y=j;
        while ( x>=0 && y<=n) {
            if ( al.contains(x+","+y)) return false;
            x--;
            y++;
        }
     //Diagonal check - from right to left
        x=i;
        y=j;
        while ( x>=0 && y>=0) {
            if ( al.contains(x+","+y)) return false;
            x--;
            y--;
        }
        return true;
    }
 
}

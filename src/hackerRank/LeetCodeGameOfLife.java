package hackerRank;

/*

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LeetCodeGameOfLife {

    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        int rows = board.length;
        int cols = board[0].length;
        int[][] out = new int[rows][cols];
        int zero_counter = 0;
        int one_counter = 0;

        for (int i = 0; i < board.length; i++ ) {
            for (int j = 0; j < board[0].length; j++ ) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        for ( int i = 0; i < rows; i++ ) {
            for (int j = 0; j < cols; j++ ) {
//                for loop for column navigation to get the neighbours
                    for ( int p = j-1; p <= j+1; p++ ) {
//                      top row neighbours
                        if ( (i-1) >=0 && p >= 0 && p < cols ) {
                            if ( board[(i-1)][p] == 0 ) zero_counter++;
                            else one_counter++;
                        }
//                      bottom row neighbours
                        if ( (i+1) < rows && p >= 0 && p < cols ) {
                            if ( board[(i+1)][p] == 0 ) zero_counter++;
                            else one_counter++;
                        }
//                        same row neighbours
                        if ( p != j && p >=0 && p < cols) {
                            if ( board[(i)][p] == 0 ) zero_counter++;
                            else one_counter++;
                        }
                    }
                if ( board[i][j] == 0 && one_counter == 3 ) out[i][j] = 1;
                else if ( board[i][j] == 1 && one_counter > 3 ) out[i][j] = 0;
                else if ( board[i][j] == 1 && ( one_counter == 2 || one_counter == 3) ) out[i][j] = 1;
                else if ( board[i][j] == 1 && one_counter < 2 ) out[i][j] = 0;
                else out[i][j] = board[i][j];

                zero_counter = 0;
                one_counter = 0;
            }
        }

        for (int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++) {
                board[i][j] = out[i][j];
            }
        }
    }

}

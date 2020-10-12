package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeSpiralMatrix {

    public static void main(String[] args) {

/*
       int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
*/

/*
        int[][] matrix = {  {1,2},
                            {3,4}
                        };
*/

/*
        int[][] matrix = {  {1,2,3},
                            {4,5,6},
                            {7,8,9}
        };
*/

/*
    int[][] matrix = {  {1,2,3,4},
                         {5,6,7,8},
                         {9,10,11,12},
                         {13,14,15,16},
        };
*/

/*    int[][] matrix = {{1},{3}}; */


  int[][] matrix = { {3} };


 /*       int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

  */

 /* int[][] matrix = {
         {1,2,3,4,5,6},
         {7,8,9,10,11,12},
         {13,14,15,16,17,18},
         {19,20,21,22,23,24},
         {25,26,27,28,29,30}
    };

  */


        boolean loop = true;

        int row = matrix.length;
        int col = 0 ;
        if ( row > 0 )
            col = matrix[0].length;


        ArrayList<Integer> out = new ArrayList<Integer>();

        int firstTraversalRow = 0;
        int firstTraversalCol = 0;
        int secondTraversalRow = 0;
        int secondTraversalCol = 0;
        int thirdTraversalRow = 0;
        int thirdTraversalCol = 0;
        int fourthTraversalRow = 0;
        int fourthTraversalCol = 0;


        int thirdTraversalIterator = 0;


        if ( row > 0 || col > 0 ) {

            if (row == 1 && col == 1) out.add(matrix[0][0]);
            else {
            while (loop) {
                if (col - firstTraversalCol >= 1) {
                    for (int i = firstTraversalCol; i < col; i++) {
                        if (out.size() < (matrix.length * matrix[0].length)) {
                            out.add(matrix[firstTraversalRow][i]);
                            firstTraversalCol = i;
                        }
                    }
                }

//                System.out.println("Output Array 1 : " + out);

                secondTraversalRow = firstTraversalRow + 1;
                secondTraversalCol = firstTraversalCol;


                if (row - secondTraversalRow >= 1) {
                    for (int i = secondTraversalRow; i < row; i++) {
                        if (out.size() < (matrix.length * matrix[0].length)) {
                            out.add(matrix[i][secondTraversalCol]);
                            secondTraversalRow = i;
                        }
                    }
                }

//                System.out.println("Output Array 2 : " + out);

                thirdTraversalRow = secondTraversalRow;
                thirdTraversalCol = secondTraversalCol - 1;


                if (col - thirdTraversalCol >= 1) {
                    for (int i = thirdTraversalCol; i >= thirdTraversalIterator ; i--) {
                        if (out.size() < (matrix.length * matrix[0].length)) {
                            out.add(matrix[thirdTraversalRow][i]);
                            thirdTraversalCol = i;
                        }
                    }
                }

                thirdTraversalIterator++;
//                System.out.println("Output Array 3 : " + out);

                fourthTraversalRow = thirdTraversalRow - 1;
                fourthTraversalCol = thirdTraversalCol;


                if (row - fourthTraversalRow >= 1) {
                    for (int i = fourthTraversalRow; i > firstTraversalRow; i--) {
                        if (out.size() < (matrix.length * matrix[0].length) && ( fourthTraversalRow - firstTraversalRow > 0 )) {
                            out.add(matrix[i][fourthTraversalCol]);
                            fourthTraversalRow = i;
                        }
                    }
                }

                /*
                System.out.println("First Traversal Row : " + firstTraversalRow);
                System.out.println("First Traversal Col : " + firstTraversalCol);
                System.out.println("Second Traversal Row : " + secondTraversalRow);
                System.out.println("Second Traversal Col : " + secondTraversalCol);
                System.out.println("Third Traversal Row : " + thirdTraversalRow);
                System.out.println("Third Traversal Col : " + thirdTraversalCol);
                System.out.println("Fourth Traversal Row : " + fourthTraversalRow);
                System.out.println("Fourth Traversal Col : " + fourthTraversalCol);
                 */

                firstTraversalRow = fourthTraversalRow;
                firstTraversalCol = fourthTraversalCol + 1;

                if ( out.size() >= (matrix.length * matrix[0].length) ) loop = false;

                col--;
                row--;

//                System.out.println("Output Array 4 : " + out);



            }
        }
        }

        System.out.println("Output : " + out);

    }



}

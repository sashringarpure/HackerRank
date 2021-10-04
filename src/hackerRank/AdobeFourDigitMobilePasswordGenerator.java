package hackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AdobeFourDigitMobilePasswordGenerator {

    public static void main(String[] args) {

        int[][] input = new int[3][3];
        ArrayList<Position> neighbour = new ArrayList<Position>();
        ArrayList<Position> finalNeighbour = new ArrayList<Position>();
        input[0] = new int[] { 1, 2, 3 };
        input[1] = new int[] { 4, 5, 6 };
        input[2] = new int[] { 7, 8, 9 };
        int row = 0;
        int col = 0;
        int index = 1;

//        for ( int[] j : input ) {
//            for ( int i : j ) {
//                System.out.println(i);
//        }
//        }
        AdobeFourDigitMobilePasswordGenerator adobeFourDigitMobilePasswordGenerator = new AdobeFourDigitMobilePasswordGenerator();
        adobeFourDigitMobilePasswordGenerator.findNeighbours(row - 1, col, row, col, neighbour);
        finalNeighbour = (ArrayList<Position>) neighbour.clone();
        while ( index > 0 ){
            for (Iterator<Position> iterator = finalNeighbour.iterator(); iterator.hasNext();) {
                Position p = iterator.next();
                neighbour.clear();
                adobeFourDigitMobilePasswordGenerator.findNeighbours(p.row-1, p.col, p.row, p.col, neighbour);
                System.out.println("Row : " + p.row + " and " + " Col : " + p.col);
                for (Position p1 : neighbour) {
                    System.out.println(p1.row+","+p1.col);
                }
            }
            index--;
        }

    }

    public void findNeighbours(int row, int col, int baseRow, int baseCol, ArrayList<Position> neighbour) {

        if (neighbour.size() == 8) {
            validNeighbours(neighbour);
            return;
        } else {
            if (row != baseRow || col != baseCol) {
                neighbour.add(new Position(row, col));
            }
            neighbour.add(new Position(row, col-1));
            neighbour.add(new Position(row, col+1));
            findNeighbours(row+1, col, baseRow,baseCol,neighbour);
        }
    }

    public void validNeighbours(ArrayList<Position> neighbour) {
        for (Iterator<Position> iterator = neighbour.iterator(); iterator.hasNext();) {
            Position p = iterator.next();
            if ( p.row < 0 || p.col < 0 || p.row > 2 || p.col > 2)
                iterator.remove();
        }
    }
}

class Position {
    int row;
    int col;

    Position (int x, int y) {
        row = x;
        col = y;
    }
}

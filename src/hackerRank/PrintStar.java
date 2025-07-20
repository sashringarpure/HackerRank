package hackerRank;

public class PrintStar {

    /*
    LOGIC:
    1. Determine the number of lines to print the star.
    2. Determine the max total spaces apart between the farthest stars.
    3. Create a for loop for the max total spaces.
    4. Create a while loop and counter for the number of lines.
    5. Use if else to determine the current space and print " " or a star.
                   *
                *       *
            *              *
        *                      *
            *               *
                *       *
                    *
     */
    public static void main(String[] args) {
        int counter = 0;
        while ( counter <= 3) {
            for (int i = 0; i <= 24; i++) {
                if (counter == 0 && i == 12) {
                    System.out.print("*");
                } else if (counter == 1 && (i == 8 || i == 16)) {
                    System.out.print("*");
                } else if (counter == 2 && (i == 4 || i == 20)) {
                    System.out.print("*");
                } else if (counter == 3 && (i == 0 || i == 24)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            counter++;
            System.out.println();
        }
        while ( counter > 0) {
            for (int i = 0; i <= 24; i++) {
                if (counter == 3 && (i == 4 || i == 20)) {
                    System.out.print("*");
                } else if (counter == 2 && (i == 8 || i == 16)) {
                    System.out.print("*");
                } if (counter == 1 && i == 12) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            counter--;
            System.out.println();
        }

    }


}

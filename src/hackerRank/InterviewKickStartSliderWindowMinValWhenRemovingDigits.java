package hackerRank;

public class InterviewKickStartSliderWindowMinValWhenRemovingDigits {

    public static void main(String[] args) {
//        int input = 123321;
//        int input = 321123;
//        int input = 111111;
//        int input = 311201;
//        int input = 54321;
//        int input = 310013;
//        int input = 32011101; window = 6
//        int input = 311001; window = 3
//        int input = 12345;
        int input = 32111001;
        int window = 5;
        int divisor = 10;
        int ans = 0;
        int counter = 0;
        int minVal = Integer.MAX_VALUE;
        int skip = 0;
        int display = 0;
        String temp;
        int ctr = 0;

        String in = String.valueOf(input);
        int left = 1;
        int right = window + 1;
        boolean scan = true ;
        final int k = window;
        StringBuilder sb = new StringBuilder();

        while ( scan ) {
            temp = in.substring(--left,(right > in.length() ? in.length() : right));
            counter = String.valueOf(temp).length();
            divisor = (int) (Math.pow(divisor, counter-1));

            while (counter > 0) {

                ans = Integer.parseInt(temp) / divisor ;
                temp = temp.substring(1,temp.length());
                divisor = divisor / 10 ;
//                skip ==> To adjust the window length based on the number of digits to the left of the minimum digit in a given window.
                skip = ans <= minVal ? ++skip : skip ;
                if ( ans == minVal)
                    ctr++;
                else {
                    minVal = minVal < ans ? minVal : ans ;
                    ctr = 0;
                }
                counter--;

            }
            while ( ctr > -1 ) {
                sb.append(minVal);
                ctr--;
            }
            left = right + 1  ;
            window = k - ( skip - 1 );
            right = left + (window == 0 ? 1 : window) ;
            if ( left > in.length() || right > in.length() || sb.length() == (in.length() - k )) {
                scan = false ;
                if  ( sb.length() < (in.length() - k ) )
                    sb.append(in.substring(left+1));
            }
            divisor = 10 ;
            skip = 0 ;
            minVal = Integer.MAX_VALUE;
        }
        System.out.println(sb.toString());
    }
}

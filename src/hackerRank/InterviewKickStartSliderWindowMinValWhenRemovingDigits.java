package hackerRank;

public class InterviewKickStartSliderWindowMinValWhenRemovingDigits {

    public static void main(String[] args) {
//        int input = 123321;
//        int input = 321123;
//        int input = 111111;
//        int input = 311201;
//        int input = 54321;
//        int input = 310013;
        int input = 311001;
//        int input = 12345;
        int window = 3;
        int divisor = 10;
        int ans = 0;
        int counter = 0;
        int minVal = Integer.MAX_VALUE;
        int skip = 0;
        int display = 0;
        String temp;

        String in = String.valueOf(input);
        int left = 0;
        int right = window + 1 ;
        boolean scan = true ;
        StringBuilder sb = new StringBuilder();


//        while ( ( sb.length() != in.length() - window ) ) {
//        while ( right <= in.length() && ( sb.length() != in.length() - window ) ) {
//        while ( right <= in.length() ) {
        while ( scan ) {
//            temp = Integer.parseInt(in.substring(left,right));
//            temp = Integer.parseInt(in.substring(left,(right > in.length() ? in.length() : right)));
            temp = in.substring(left,(right > in.length() ? in.length() : right));
//            counter = in.substring(left,right).length();
            counter = String.valueOf(temp).length();
            divisor = (int) (Math.pow(divisor, counter-1));

            while (counter > 0) {

                ans = Integer.parseInt(temp) / divisor ;
//                temp = Integer.parseInt(temp) % divisor ;
                temp = temp.substring(1,temp.length());
                divisor = divisor / 10 ;
                skip = ans <= minVal ? ++skip : skip ;
//                if ( minVal == ans ) {
//                    sb.append(minVal);
//                }
                minVal = minVal < ans ? minVal : ans ;
                counter--;

            }
            if ( right > in.length() ) {
                scan = false ;
            }

            sb.append(minVal);
//            left = ( left + skip) > in.length() ? in.length() : (left + skip) ;
//            right = ( right + skip) > in.length() ? in.length() : ( right + skip ) ;
//            right = left == right ? in.length() + 1 : right ;
            left = left + skip ;
            right = right + skip ;
            divisor = 10 ;
            skip = 0 ;
            minVal = Integer.MAX_VALUE;
        }
        display = in.length() - window ;
        System.out.println(sb.toString());
//        System.out.println(sb.toString().substring(sb.length()-display,sb.length()));
    }
}

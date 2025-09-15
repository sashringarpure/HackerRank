package hackerRank;

public class LongestPalindromeInAString {

    public static void main(String[] args) {
        String s = "babad";
        int len1 = 0; //for odd length palindrome
        int len2 = 0; //for even length palindrome
        int length = Integer.MIN_VALUE;
        int start = 0; //for start of the palindrome string.
        int end = 0; //for end of the palindrome string.

        for (int i = 0; i <s.length() ; i++ ) {
            len1 = LongestPalindromeInAString.expandAroundCenter(s, i, i);//Odd length palindrome.
            len2 = LongestPalindromeInAString.expandAroundCenter(s, i, i + 1);//Even length palindrome.
            length = Math.max(len1, len2); //determine the longest palindrome.
            if ( length > (end - start) ) { //capture the start and the end of the longest palindrome.
                start = i - (length - 1) / 2 ;
                end = i + length / 2;
            }
        }
        System.out.println("Longest palindrome is : " + s.substring(start, end + 1));

    }

    public static int expandAroundCenter(String s, int left, int right) {
        while ( left >= 0 && right < s.length() && ( s.charAt(left) == s.charAt(right)) ) {
            left--;
            right++;
        }
        return right - left -1 ;
    }
}

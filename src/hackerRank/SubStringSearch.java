package hackerRank;

// Write a program for : String is a substring of another substring.

import java.util.Locale;

public class SubStringSearch {

    public static void main(String[] args ) {
    String s1 = "test";//4
        s1 = s1.replaceAll(" ","");
        s1 = s1.toLowerCase(Locale.ROOT);
    String s2 = "  ";//3
        s2 = s2.replaceAll(" ","");
        s2 = s2.toLowerCase(Locale.ROOT);
    char[] cs1 = s1.toCharArray();
    char[] cs2 = s2.toCharArray();
    int lens2 = s2.length();
    boolean flag = false;

    if ( s1.length() > 0 && s2.length() > 0 ) {
        for (int i = 0; i <= (cs1.length - cs2.length); i++) {
            if (s1.substring(i, (i + s2.length())).equals(s2)) {
                flag = true;
                break;
            }
            //System.out.println(s1.substring(i,(i+s2.length())));
        }
        if ( flag ) System.out.println("match found.");
        else System.out.println("Match not found.");
    } else {
        System.out.println("String length has to be > 0");
    }




    }
}

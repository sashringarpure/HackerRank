package hackerRank;

import java.util.HashMap;

public class MaxDistanceBetweenTwoSameChars {

    public static void main(String[] args) {

        int result = 0;
        String s1 = "my name is granaez";
        String s2 = "y";
        int leftIndex = 0;
        int rightIndex = 0;
        char[] ch1 = s1.replaceAll(" ","").toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();

        int i = 0;
        while ( ch1[i] != s2.charAt(0) && i < ch1.length) {
            i++;
        }
        if ( i == ch1.length) {
            result = -1;
        } else {
            leftIndex = i;
        }

        i = ch1.length - 1;
        while ( ch1[i] != s2.charAt(0) && i > 0 ) {
            i--;
        }
        if ( i == leftIndex || i == 0 ) {
            result = -1;
        } else {
            rightIndex = i;
        }

        if ( result != -1 ) {

            for (int j = leftIndex + 1; j <= rightIndex; j++) {

                if (!hm.containsKey(ch1[j]) && ch1[j] != s2.charAt(0)) {
                    hm.put(ch1[j], 1);
                    result++;
                }
            }

        }


        System.out.println(result);


    }
}

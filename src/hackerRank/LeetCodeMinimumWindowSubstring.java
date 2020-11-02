package hackerRank;
/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

*/

import java.util.ArrayList;

public class LeetCodeMinimumWindowSubstring {

    public static void main(String[] args) {
        String temp = "";
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String output = s;
        ArrayList<Character> at = new ArrayList<Character>();
        ArrayList<Character> tTemp = new ArrayList<Character>();
        for (char ch : t.toCharArray()) {
            at.add(ch);
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ( tTemp.size() != t.length() ) {
                temp = temp + ch[i];
            }
            if ( temp.length() == 1 && !at.contains(ch[i]) ) temp = "";
            if ( at.contains(ch[i]) ) {
                tTemp.add(ch[i]);
                at.remove(at.indexOf(ch[i]));
            }
            if ( tTemp.size() == t.length() && at.size() == 0 ) {
                at.addAll(tTemp);
                tTemp.removeAll(tTemp);
                if ( temp.length() < output.length() ) output = temp;
                temp = "";
            }
        }
        System.out.println(output);
     }
}

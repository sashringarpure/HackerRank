package hackerRank;

import java.util.HashMap;

public class LeetCodeRomanToInteger {
    public static void main(String[] args) {
        String s = "MDCLXVI";
        int i = 0;
        int result = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        while(i<=s.length()-2) {
            if (hm.get(s.substring(i,i+1)) > hm.get(s.substring(i+1,i+2)) ) {
                result = result + hm.get(s.substring(i, i + 1));
                i++;
            } else if (hm.get(s.substring(i+1,i+2)) > hm.get(s.substring(i,i+1))) {
                result = result + (hm.get(s.substring(i+1,i+2)) - hm.get(s.substring(i,i+1)));
                i=i+2;
            }
            System.out.println(i);
        }
        if (i < s.length() ) result = result + hm.get(s.substring(i));
        System.out.println(result);
    }
}

package hackerRank;

import java.util.HashMap;

public class LeetCodeFindtheDuplicateNumber {

    public static void main(String[] args) {

//        int[] nums = {1,3,4,2,2};
//        int[] nums = {3,1,3,4,2};
//        int[] nums = {1,1};
        int[] nums = {-1,-1,2};
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        Integer integer = 0;
        for ( int i : nums ) {
            integer = (Integer) i;
            if ( hm.containsKey(integer) ) {
                break;
            } else {
                hm.put(integer, 1);
            }
        }
        System.out.println(integer);
    }
}

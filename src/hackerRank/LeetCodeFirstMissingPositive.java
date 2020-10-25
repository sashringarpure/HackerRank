package hackerRank;

/*

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

    HashSet<Integer> hs = new HashSet<Integer>();
    TreeSet<Integer> ts = new TreeSet<Integer>();
    SortedSet<Integer> ss = new TreeSet<Integer>();
    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    Hashtable<Integer,Integer> ht = new Hashtable<Integer, Integer>();
    TreeMap<Integer,Integer> tm = new TreeMap<Integer, Integer>();
    Map<Integer,Integer> m = new HashMap<Integer, Integer>();


    Iterator hsi = hs.iterator();
    Iterator tsi = ts.iterator();

 */

import java.util.*;

public class LeetCodeFirstMissingPositive {

    public static void main(String[] args ) {

//        int[] nums = {3,4,-1,1};
//        int[] nums = {1,2,0};
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {};


        int[] nums = {-5,-4,-3};
        int out = 0;
        SortedSet<Integer> ts = new TreeSet<Integer>();
        for (int i : nums ) {
            ts.add(i);
        }
        if ( ts.size() > 0 ) {
            out = ts.last() + 1;
            for (int i = 1; i <= ts.last(); i++) {
                if (ts.contains(i)) continue;
                else {
                    out = i;
                    break;
                }
            }
            if ( out<= 0 ) out = 1;
        }
        else
            out = 1;

        System.out.println(out);

    }

}

package hackerRank;

import java.util.*;

/*

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 */
public class LeetCodeLongestConsecutiveSequence {

    public static void main(String[] args ) {

        int counter = 1;
        int tracker = 0;
        int longestSequence = 1;
        int temp = 0;
        Integer integer;
        SortedSet<Integer> ss = new TreeSet<Integer>();
        int[] nums = {100,4,200,1,3,2};
//        Integer[] nums = {100,200};
//        Integer[] nums = {100};
        for ( int i : nums ) {
            integer = (Integer) i;
            ss.add(integer);
        }
        Iterator<Integer> ssi = ss.iterator();
        if ( nums.length > 0) {
            tracker = ssi.next();
            while (ssi.hasNext()) {
                temp = ssi.next();
                if (++tracker == temp) {
                    counter++;
                    longestSequence = Math.max(counter, longestSequence);
                } else {
                    longestSequence = Math.max(counter, longestSequence);
                    tracker = temp;
                    counter = 1;
                }
            }
        } else longestSequence = 0;
        System.out.println(longestSequence);
    }
}

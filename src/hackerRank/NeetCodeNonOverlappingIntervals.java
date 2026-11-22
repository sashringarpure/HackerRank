package hackerRank;
import java.util.Arrays;

public class NeetCodeNonOverlappingIntervals {

// Given an array of intervals where intervals[i] = [start_i, end_i],
// return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
// Input: intervals = [[1,2],[2,4],[1,4]]
// Output: 1
// Logic:
// Sort the array based on start time.
// Traverse the array.
// Set two counters. Initialize first one to 0 and the second one to "first+1".
// If the start time for two consecutive elements is the same, increment the result counter by one,
// and increment the second counter by one. Else, set first counter to second counter and set second counter to "first+1"
        public static void main(String args[]) {
            //2d array.
            //int[][] intervals = {{1,2},{2,4},{1,4}};
            int[][] intervals = {{1, 2}, {1, 4}};
            //Functional Programming - Sort 2d array.
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int i = 0;
            int j = 1;
            int result = 0;
            while (j < intervals.length) {
                if (intervals[i][0] == intervals[j][0]) {
                    result++;
                    j++;
                } else {
                    i = j;
                    j = i + 1;
                }
            }
            System.out.println(result);
        }

}

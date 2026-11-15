package hackerRank;
import java.util.*;
// Merge Intervals.
// Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
// Example 1:
// Input: intervals = [[1,3],[1,5],[6,7]]
// Output: [[1,5],[6,7]]
// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// LOGIC:
// Insert the first element in the result set.
// Traverse the input from the second element (index = 1 )
// Merge the intervals if the end time of the prior interval is >= start time of the next interval.
// Since this is a 2D array, we need to call the Array List methods twice to access the elements.
// We need to call Arrays.asList to support the conversion from integer to Integer.

public class NeetCodeMergeIntervals {
        public static void main(String args[]) {
            //int[][] intervals = {{1,3}, {1,5}, {6,7}};
            int[][] intervals = {{1,2}, {2,3}};
            List<List<Integer>> result = new ArrayList<>();
            // Insert the first element in the result set.
            result.add(Arrays.asList(intervals[0][0], intervals[0][1]));
            // Traverse the input from the second element (index = 1 )
            int index = 1;
            while (index < intervals.length ){
                // Merge the intervals if the end time of the prior interval is >= start time of the next interval.
                // Since this is a 2D array, we need to call the Array List methods twice to access the elements.
                if (result.get(result.size()-1).get(1) >= intervals[index][0] ){
                    result.get(index-1).set(0,
                            Math.min(result.get(index-1).get(0), intervals[index][0]));
                    result.get(index-1).set(1,
                            Math.max(result.get(index-1).get(1), intervals[index][1]));
                } else {
                    result.add(Arrays.asList(intervals[index][0], intervals[index][1] ));
                }
                index++;
            }
            System.out.println(result);
        }
    }

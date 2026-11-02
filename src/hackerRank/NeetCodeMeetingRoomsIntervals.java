package hackerRank;

import java.util.*;

public class NeetCodeMeetingRoomsIntervals {
    public static void main(String args[]) {
        List<List<Integer>> result = new ArrayList<>();
        //Meeting Rooms exercise
        // int[][] intervals = {{1,2},{3,4},{5,6},{7,8}};
        // int[] newInterval = {6,7};
        //Insert interval exercise.
        int[][] intervals = {{1,3}, {4,6}};
        int[] newInterval = {2,5};
        //An interval occurs before if it's end time is less than the start time of the new interval. Insert current interval in the result.
        //An interval occurs after if it's start time is greater than the end time of the new interval. Insert new interval in the result
        //and current interval becomes the new interval otherwise we wil loose out the current interval.
        //Merge the overlapping intervals into the new interval by determining the min and the max start and end times of current and the
        //new interval.
        //Insert the last remaining interval from the new interval array into the result.
        for (int[] currInterval: intervals) {
            //An interval occurs before if it's end time is less than the start time of the new interval. Insert current interval in the result.
            if (currInterval[1] < newInterval[0]) {
                result.add(new ArrayList<>(Arrays.asList(currInterval[0],currInterval[1])));
            }
            //An interval occurs after if it's start time is greater than the end time of the new interval. Insert new interval in the result
            //and current interval becomes the new interval otherwise we wil loose out the current interval.
            else if (currInterval[0] > newInterval[1]) {
                result.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
                newInterval[0] = currInterval[0];
                newInterval[1] = currInterval[1];
            } else {
                //Merge the overlapping intervals into the new interval by determining the min and the max start and end times of current and the
                //new interval.
                newInterval[0] = Math.min(currInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        }
        //Insert the last remaining interval from the new interval array into the result.
        result.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
        System.out.println(result);
    }
}
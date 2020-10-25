package hackerRank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Input: height = [1,1]
Output: 1

Input: height = [4,3,2,1,4]
Output: 16

Input: height = [1,2,1]
Output: 2


 */
public class LeetCodeContainerWithMostWater {

    public static void main(String[] args ) {

//        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};
//        int[] height = {4,3,2,1,4};
//        int[] height = {1,2,1};
//        int[] height = {1};
        int[] height = {
                5,1,2,4,3
        };

        int i = 0;
        int j = height.length - 1;
        int area = 0;

        while ( i < j ) {

            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if ( height[i] > height[j] ) j -=1 ;
            else i +=1 ;


        }

        System.out.println(area);

    }
}

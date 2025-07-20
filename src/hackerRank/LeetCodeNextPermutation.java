package hackerRank;

import java.util.Arrays;

public class LeetCodeNextPermutation {
    public static void main(String[] args) {
        int[] input = {1,2,3,1};
        int pivot = 0;
        int smallest_ele_greater_than_pivot = Integer.MAX_VALUE;
        int temp;
        /*
        Traverse the array from right to left and find the first element that is smaller than the element
        to its right. This element will be the "pivot.
         */
        for (pivot = input.length-1; pivot >= 0; pivot-- ) {
            if (input[pivot-1] < input[pivot]) break;
            else continue;
        }
        System.out.println(input[pivot-1]);
        /*
        Find the smallest element greater than the pivot from the right side of the array.
         */
        for (int i = pivot; i < input.length; i++){
            if (input[i] > input[pivot-1] && (input[i] - input[pivot-1]) < smallest_ele_greater_than_pivot )
                smallest_ele_greater_than_pivot = i;
        }
        System.out.println(input[smallest_ele_greater_than_pivot]);
        /*
        Swap the pivot with this larger element:
         */
        temp = input[pivot-1];
        input[pivot-1] = input[smallest_ele_greater_than_pivot];
        input[smallest_ele_greater_than_pivot] = temp;
        System.out.println(Arrays.toString(input));
        /*
        reverse the part of the sequence that comes after the position of the pivot.
         */
    }
}

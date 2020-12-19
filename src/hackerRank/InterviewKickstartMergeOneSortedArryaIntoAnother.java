package hackerRank;

import java.util.Arrays;

/*
Merge One Sorted Array Into Another
Given two arrays:
1) arr1 of size n, which contains n positive integers sorted in the ascending order.
2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).
Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly sorted array of (2*n) positive integers.
Example
Input:
n = 3
arr1 = [1 3 5]
arr2 = [2 4 6 0 0 0]
Output: arr2 = [1 2 3 4 5 6]
Notes
Input Parameters: There are two arguments. First one is an integer array denoting arr1 and second one is also an integer array denoting arr2.
Output: You don't have to return anything. You just need to modify the given array arr2.
Constraints:
1 <= n <= 10^5
1 <= arr1[i] <= 2 * 10^9
1 <= arr2[i] <= 2 * 10^9 (for the first half)
arr2[i] = 0 (for the second half)
You can use only constant extra space.
0 denotes an empty space.
Custom Input
Input Format: The first line of input should contain an integer n, denoting size of input array arr1. In next n lines, ith line should contain an integer arr1[i], denoting value at index i of arr1.
In next line, there should be an integer (2*n), denoting size of input array arr2. In next (2*n) lines, ith line should contain an integer arr2[i], denoting value at index i of arr2.
If n = 3, arr1 = [1, 3, 5] and arr2 = [2, 4, 6, 0, 0, 0], then input should be:
3
1
3
5
6
2
4
6
0
0
0
Output Format: There will (2*n) lines of output, where ith line contains an integer arr2[i], denoting value at index i of arr2. For input n = 3, arr1 = [1, 3, 5] and arr2 = [2, 4, 6, 0, 0, 0], output will be:
1
2
3
4
5
6

1. Since both the input arrays are sorted in increasing order, and the resultant merged array should be sorted,
we will start with the last element of array-1 and the last non-zero element of array-2.
2. We will start with the last non-zero element of array-2 since the extra zeroes in array-2 is space reserved to merge array-1.
3. Declare variable to point to last element of array-1.
4. Declare variable to point to the last non-zero element of array-2.
5. Declare a variable to store the insertion index for array-2. This will initially point to the last element position in array-2.
And will be used to insert the max element in array-2 in a descending order.
6. (While) loop till array-1 index and array-2 comparison index is greater than or equal to zero.(Since we start from right of the array)
  a. If the element in array-1 is greater than the element in array-2:
   i. Insert element from array-1 in the insertion index of array-2.
   ii. Decrease loop counter for array-1.
   iii. Decrease insertion index counter for array-2.
  b. If the element in array-2 is greater than the element in array-1:
   i. Insert element from array-2 in the insertion index of array-2.
   ii. Decrease comparison index counter for array-2.
   iii. Decrease insertion index counter for array-2.
7. (While loop) for any elements in array-1 which remain to be merged after step 6(This may happen if all the elements
in sorted array2 are greater than the elements in sorted array1, thereby causing all the elements in array-2 to be
shifted to the right of the array. In step 6, Array-1 index counter will not decrease till it encounters an element which is
greater than the corresponding comparison element from array-2)
  a. Insert elements from the array-1 index position to the array-2 insertion index position
  b. Decrease array-2 insertion index
  c. Decrease array-1 index
8. (While loop) for any elements in array-2 which remain to be merged after step 6(This may happen if all the elements
in sorted array1 are greater than the elements in sorted array2, thereby causing all the elements in array-1 to be
inserted into array-2 starting from the last position. In step 6, Array-2 index counter will not decrease till it encounters an element which is
greater than the corresponding comparison element from array-1)
  a. Insert elements from the array-1 index position to the array-2 insertion index position
  b. Decrease array-2 insertion index
  c. Decrease array-1 index
 */
public class InterviewKickstartMergeOneSortedArryaIntoAnother {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,7};
        int[] arr2 = {4,5,6,0,0,0,0};

        int arr1_index = arr1.length-1;
        int arr2_comparison_index = arr2.length - arr1.length - 1;
        int insertion_index = arr2.length - 1;

        while ( arr2_comparison_index >= 0 && arr1_index >= 0 ) {
            if (arr1[arr1_index] > arr2[arr2_comparison_index]) {
                arr2[insertion_index] = arr1[arr1_index];
                arr1_index--;
                insertion_index--;
            } else
            {
                arr2[insertion_index] = arr2[arr2_comparison_index];
                arr2_comparison_index--;
                insertion_index--;
            }
        }

        while (arr1_index >= 0) {
            arr2[insertion_index] = arr1[arr1_index];
            arr1_index--;
            insertion_index--;
        }

        while (arr2_comparison_index >= 0) {
            arr2[insertion_index] = arr2[arr2_comparison_index];
            arr2_comparison_index--;
            insertion_index--;
        }

        System.out.println(Arrays.toString(arr2));
    }

}

package hackerRank;

import java.util.ArrayList;

/**
 * Logic:
 * Traverse recursively the input array using the two approaches below:
 * Approach 1: Starting from each index, add numbers at each index of the traversed input array
 * Add the number at the index location
 * If the sum is less than the target:
 *  add the index to the results array, to account for numbers at all the index positions which match the target number
 * If the sum equals to the target:
 *  add the index to the results array, to get the list of all the indexes;
 *  print the contents of the array;
 *  remove the last added index from the results array to continue the search for subsequent matches
 *  subtract the last added number from the sum, to continue the search for subsequent matches
 *  If the sum is greater than the target:
 *      subtract the last added number from the sum, to continue the search for subsequent matches
 *  If the index equals the last element of the array:
 *      add the number at this index location
 *      Perform the check if the sum of all the added numbers equals the target number.
 *      Print the results array
 *  return
 * Approach 2:Add two numbers, one is the start index and the other is after incrementing the index
 * If the sum equals to the target:
 *  Check for duplicate index and add the index to the result array.
 *  Print the results.
 * Baseline the sum to the start index location within the traversed input array.
 * Clear out the results array and add the start index of the traversed input array to the results array
 * If the index equals the last element of the array:
 *  add the number at this index location
 *  Perform the check if the sum of the added numbers equals the target number.
 *  Print the results array
 * return
 */
public class Life360ScanArrayToMatchTargetNumber {


    public static void main(String[] args) {

//        int[] input = {1,2,3,4,5,9};
        int[] input = {1,1,1,1,1};
        int target = 4;

        ArrayList<Integer> resultIndex = new ArrayList<Integer>();
        ArrayList<Integer> resultIndexExactMatch = new ArrayList<Integer>();

        for (int i = 0 ; i < input.length ; i++) {
            resultIndex.clear();
            resultIndexExactMatch.clear();
            resultIndexExactMatch.add(i);
            recursion(input, target, resultIndex, i, 0, 0,i, resultIndexExactMatch);
        }

    }

    public static void recursion(int[] input, int target, ArrayList<Integer> result, int index, int sum, int sum1, int baseIndex,
                                ArrayList<Integer> result1) {

            if (index == input.length - 1) {
                sum = sum + input[index];
                sum1 = sum1 + input[index];
                if (sum == target) {
                    result.add(index);
                    System.out.println(result);
                }
                if ( sum1 == target ) {
                    result1.add(index);
                    System.out.println(result1);
                }
                return;
            }
            else {
            sum = sum + input[index];
            sum1 = sum1 + input[index];
            if ( sum1 == target ) {
                if (! result1.contains(index))
                    result1.add(index);
                System.out.println(result1);
            }
            if ( sum < target ) {
                result.add(index);
            }
            if ( sum == target) {
                    result.add(index);
                    System.out.println(result);
                    result.remove(result.size()-1);
                    sum = sum - input[index];
            }
            if ( sum > target ) sum = sum - input[index];
            sum1 = input[baseIndex];
            result1.clear();
            result1.add(baseIndex);
            recursion(input, target, result, ++index, sum, sum1, baseIndex, result1);
        }
    }
}

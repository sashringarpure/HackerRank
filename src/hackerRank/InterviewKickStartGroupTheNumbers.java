package hackerRank;

/**
 *
 * You are given an integer array arr of size n. Group and rearrange them (in-place) into evens and odds in such a way
 * that group of all even integers appears on the left side and group of all odd integers appears on the right side.
 * Example
 * Input: [1, 2, 3, 4]
 * Output: [4, 2, 1, 3]
 * Order does not matter. Other valid solutions are:
 *
 * [2, 4, 1, 3]
 *
 * [2, 4, 3, 1]
 *
 * [4, 2, 3, 1]

 * Notes
 *
 * Input Parameters: There is only one argument: Integer array arr.
 * Output: Return the same integer array, with evens on left side and odds on the right side.
 *
 * There is no need to preserve order within odds or within evens.
 * Constraints:
 *
 * 1 <= n <= 10^5
 * arr contains only positive integers.
 * arr may contain duplicate numbers.
 * Solution with linear time complexity and constant auxiliary space is expected.
 *
 *
 * Custom Input
 *
 * Input Format: The first line of input should contain an integer n, denoting size of input array arr. In next n lines, ith line should contain an integer arr[i], denoting a value at index i of arr.
 *
 * If n = 4 and arr = [1, 2, 3, 4], then input should be:
 *
 * 4
 *
 * 1
 *
 * 2
 *
 * 3
 *
 * 4
 *
 *
 *
 * Output Format: There will be n lines of output, where ith line contains an integer res[i], denoting value at index i of res.
 *
 * Here, res is the result array returned by solution function.
 *
 * For input n = 4 and arr = [1, 2, 3, 4], output will be:
 *
 * 4
 *
 * 2
 *
 * 1
 *
 * 3
 *
 */

public class InterviewKickStartGroupTheNumbers {

    public static void main(String[] args) {

        int[] arr = {8,4,9,5,2,9,5,7,10};
        boolean even_flag = false;
        boolean odd_flag = false;
        int temp = 0;
        for (int i = 0, j = arr.length-1; i < j; i++, j-- ){
            if (arr[i] % 2 == 0) even_flag = true;
            if (arr[j] % 2 != 0) odd_flag = true;
            if (even_flag && !odd_flag) {  //if odd number is found on the left hand side, then, swap it with the next element of the right hand side
                temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
                ++j;
                --i;
            }
            if (odd_flag && !even_flag) { //if even number is found on the right hand side, then, swap it with the next element of the left hand side
                temp = arr[i];
                arr[i] = arr[--j];
                arr[j] = temp;
                j++;
                --i;
            }
            if (!odd_flag && !even_flag) { //swap the elements if odd number is found on L.H.S and even number is found on R.H.S.
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                temp = 0;
            }
            even_flag = false;
            odd_flag = false;
        }
        for (int a : arr) System.out.println(a);

    }


}

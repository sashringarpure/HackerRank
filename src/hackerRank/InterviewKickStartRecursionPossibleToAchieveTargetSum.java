package hackerRank;
import java.util.ArrayList;
/*
Possible To Achieve Target Sum?
Given a set of integers and a target value k, find a non-empty subset that sums up to k.
Example One
Input: [2 4 8], k = 6
Output: True
Because 2+4=6.
Example Two
Input: [2 4 6], k = 5
Output: False
Because no subset of numbers from the input sums up to 5.
Notes
Input Parameters: Function has two arguments: an array of integers (their order doesn’t matter) and the target value  k.
Output: Function must return a boolean value.
Constraints:
1 <= size of the input array <= 18
-10^12 <= elements of the array, k <= 10^12
Custom Input
Input Format: First line of input contains integer n, size of arr. Next n lines contain integer elements of arr. Next line contains integer k. If arr = [2, 4, 8] and k = 6, custom input would be:
3
2
4
8
6
Output Format: Valid output consists of a single character on a single line: 0 for False or 1 for True. For input arr = [2, 4, 8] and k = 6, correct output would be:
1
2,4,8,6
8,-11,8
-2,2,1,2,3,0
1,2,3,4,5,5
-5,8,2,11,-8,14
-10000000000,-10000000000,-80000000000,-30000000000,-180000000000,110000000000,60000000000,-90000000000
*/

public class InterviewKickStartRecursionPossibleToAchieveTargetSum {

    public static void main(String[] args ) {

//        long[] arr = {-5,8,2,11,-8};
//        long k = 14;
//        long[] arr = {-2,2,1,2,3};
//        long k = 0;
        long[] arr = {1};
        long k = 0;
        ArrayList<Boolean> flag = new ArrayList<Boolean>();
        boolean eleAdded = false;

        flag = recursionHelper(arr,0,new long[arr.length],0, k, flag, eleAdded);

        System.out.println(flag);

    }

    public static ArrayList<Boolean> recursionHelper(long[] arr, int spos, long[] temp, int tempIndex, long target, ArrayList<Boolean> flag, boolean eleAdded) {



        if ( spos == arr.length ) {

            if ( recursiveAddition(temp, tempIndex - 1 >= 0 ? tempIndex - 1 : 0 ) == target && eleAdded ) {
                flag.add(true);
            }

            return flag;
        }

            recursionHelper(arr, spos + 1, temp, tempIndex, target, flag, eleAdded );
            temp[tempIndex] = arr[spos];
            eleAdded = true;
            return recursionHelper(arr, spos + 1, temp, tempIndex + 1, target, flag, eleAdded);


    }

    public static long recursiveAddition(long[] arr, int spos) {

        if ( spos == 0 ) {
            return arr[spos];
        } else {
            return arr[spos]  + recursiveAddition(arr, spos-1);
        }


    }


}

package hackerRank;

/*
LockboxSupport@uscis.dhs.gov
Name/dob/type of form/trk no

Write a function that returns the number of distinct binary search trees that can be constructed with n nodes.
For the purpose of this exercise, do solve the problem using recursion first even if you see some non-recursive approaches.
 Example One
Input: 1
 Output: 1
 Example Two
Input: 2
 Output: 2
 Suppose the values are 1 and 2, then the two trees that are possible are
   (2)               (1)
  /          and       \
(1)                     (2)
 Example Three
Input: 3
 Output: 5
Suppose the values are 1, 2, 3 then the possible trees are
       (3)
      /
    (2)
   /
(1)
 
   (3)
  /
(1)
   \
   (2)
 
(1)
   \
    (2)
      \
       (3)
 
(1)
   \
    (3)
   /
(2)
 
   (2)
  /   \
(1)    (3)
 
Notes
Input Parameters: Function has one argument: n.
 Output: Function must return an integer value.
 Constraints:
	•	1 <= n <= 16
 Custom Input
Custom Input Format: 
First and only line of input contains integer n. For example: 3
 
Custom Output Format: The only line of the output must contain the answer (the integer value). For input n=3, correct output is: 5

Formula:
Cn = (2n)! / n! *(n+1)!
 */

import java.math.BigInteger;
import java.util.Arrays;

public class InterviewKickStartHowManyBinarySearchTrees {

//    7,8,9,10,11,12
//    429, 1430, 4862, 16796, 58786, 208012
    public static void main(String[] args) {
        int n = 16;
        Long l1;
        BigInteger l = BigInteger.valueOf(Long.valueOf(n));
        BigInteger res = factorial(BigInteger.TWO.multiply(l)).divide(factorial(l).multiply(factorial(BigInteger.ONE.add(l))));
        l1 = res.longValue();
        System.out.print(l1);
    }


    public static BigInteger factorial(BigInteger n) {

        if ( n.equals(BigInteger.ZERO) ) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }


//    static long [] memo;
//
//    public static void main(String[] args) {
//
//        int n = 5;
//        memo = new long[n+1];
//        Arrays.fill(memo, -1L);
//        System.out.println(how_many_BSTs_helper(n));
//    }
//
//    static long how_many_BSTs_helper(int n) {
//        if (memo[n] != -1L) return memo[n];
//        if ( n == 0 ) return 1L;
//        long count = 0L;
//        for ( int l = 0; l < n; l++ ) {
//            int r = n - 1 - l;
//            count += how_many_BSTs_helper(l)*how_many_BSTs_helper(r);
//        }
//        memo[n] = count;
//        return count;
//    }




}

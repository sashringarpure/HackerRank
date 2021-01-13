/*
linkedinLearning : Management Conflict,
hbr.org
Find All Well Formed Brackets
Find All Well Formed Brackets
 Given a positive integer n, return ALL strings of length 2*n with well formed round brackets.
 Example
Input: 3
Output:
[
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
]
 Any array containing these five strings in any order is a correct output.
 Notes
Input Parameters: Function has one argument, integer n. 
Output: Return array of strings containing all possible well formed round brackets string of length 2*n. Order of strings in the returned array is insignificant, e.g. for n=2 both ["(())", "()()"] and ["()()", "(())"] will be accepted.
 Constraints:
	•	1 <= n <= 13
	•	Only use round brackets. '(' and ')'.
 Custom Input
Input Format: There should be one line for input, containing an integer n. If n = 3, then input should be:
3
 Output Format: Let’s denote the size of res is m, where res is the resultant array of string returned by the solution function.
Then, there will be m lines of output, where ith line contains res[i], denoting string at index i of res.
For input n = 3, output will be:
((()))
(()())
(())()
()(())
()()()
*/

package hackerRank;
import java.util.ArrayList;

public class InterviewKickStartRecursionFindAllWellFormedBrackets {

    public static void main(String[] args ) {

        int n = 3;
        ArrayList<String> res = new ArrayList<String>();
        Integer left = 0;
        Integer right = 0 ;
        Boolean isValid = false;
        helper(n, "", res, left, right, isValid);
        for (String s: res)
            System.out.println(s);

    }


    public static void helper(int n, String temp, ArrayList<String> res, Integer left, Integer right, Boolean isValid) {

        if ( temp.length() == 2*n || right > left || left > n || right > n  ) {
            if ( isValid ) {
                res.add(temp);
            }
            return;
        } else {

            left = left + 1;
            if ( left > n || right > n || ( temp.length() - right ) < n || temp.substring(0,1).equals(")")  ) {
                isValid = false;
            } else {
                isValid = true;
            }
            helper(n, temp + "(", res,left, right, isValid);
            left = left - 1;
            right = right + 1;
            if ( left > n || right > n || right > left || temp.substring(0,1).equals(")")  ) {
                isValid = false;
            } else {
                isValid = true;
            }
            helper(n, temp + ")", res, left, right, isValid);
            right = right - 1;
        }
        return;


    }
}



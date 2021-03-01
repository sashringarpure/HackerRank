package hackerRank;

import jdk.jshell.JShell;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InterviewKickStartRecursionGenerateAllPossibleExpressions {

    public static void main(String[] args) {
    ArrayList<String> result = new ArrayList<String>();
    String s = "123";
    long target = 6;
    char[] digits = s.toCharArray();
    char[] expr = new char[s.length()*2];
    long n = 0;
    for (int i = 0; i < digits.length;i++) {
        n = n * 10 + (digits[i]-'0');
        expr[i] = digits[i];
        helper(result, digits, expr, i+1, i+1, 0, n, target );
    }

    }

    public static void helper(ArrayList<String> result, char[] digits, char[] expr, int pos, int len, long prev, long curr, long target) {
        if ( pos == digits.length ) {
                if ( prev + curr == target) {
                    System.out.println(new String(expr, 0, len));
                }
            return;
        } else {
            for ( int i = pos; i < digits.length;i++) {
                expr[len] = '*';
                expr[len+1] = digits[i];
                helper(result, digits, expr, pos+1, len+2, prev, curr * (digits[i] - '0'), target );
                expr[len] = '+';
                helper(result, digits, expr, pos+1, len+2, prev+curr, (digits[i] - '0') , target );
            }
        }
    }




}

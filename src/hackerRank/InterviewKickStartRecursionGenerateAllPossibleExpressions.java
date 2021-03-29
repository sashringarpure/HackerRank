package hackerRank;

import jdk.jshell.JShell;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InterviewKickStartRecursionGenerateAllPossibleExpressions {

    public static void main(String[] args) {

        //System.out.println(generate_all_expressions("123", 6));
        System.out.println(generate_all_expressions("222", 24));
        //System.out.println(generate_all_expressions("22", 4));
        //System.out.println(generate_all_expressions("1234", 11));
        //System.out.println(generate_all_expressions("1123", 124));
        //System.out.println(generate_all_expressions("52341", 20));
        //System.out.println(generate_all_expressions("050505", 5));
        //System.out.println(generate_all_expressions("40404040", 0));
        //System.out.println(generate_all_expressions("05050505", 0));
    }


    static String[] generate_all_expressions(String s, long target) {

        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) return result.toArray(new String[0]);
        char[] expr = new char[s.length() * 2];
        char[] digits = s.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + (digits[i] - '0');
            expr[i] = digits[i];
            helper(result, digits, expr, i + 1, i + 1, 0, n, target);
        }
        return result.toArray(new String[0]);
    }

    public static void helper(ArrayList<String> result, char[] digits, char[] expr, int pos, int len, long prev, long curr, long target) {
        if (pos == digits.length) {
            if (prev + curr == target) {
                result.add(new String(expr, 0, len));
                System.out.println(new String(expr, 0, len));
            }
            return;
        } else {
            long n = 0;
            int j = len + 1;
            for (int i = pos; i < digits.length; i++) {
                n = n * 10 + (digits[i] - '0');
                expr[len] = '*';
                //expr[len + 1] = digits[i];
                expr[j++] = digits[i];
                //helper(result, digits, expr, i + 1, len + 2, prev, curr * n, target);
                helper(result, digits, expr, i + 1, j, prev, curr * n, target);
                expr[len] = '+';
                //helper(result, digits, expr, i + 1, len + 2, prev + curr, n, target);
                helper(result, digits, expr, i + 1, j, prev + curr, n, target);
            }
        }
    }


}
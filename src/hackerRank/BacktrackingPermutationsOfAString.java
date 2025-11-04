package hackerRank;

import java.util.ArrayList;
//For loop in the recursive function.
//Fix a character from the input. Line 25.
//Form a string of remaining characters from the input. Line 26.
//Add the fixed character to the string buffer. Line 27.
//Call recursion with remaining characters as the input. Line 28.
//Backtrack, i.e. delete the prior character from the string buffer. Line 29.

public class BacktrackingPermutationsOfAString {
    public static void main(String[] args) {
        String input = "ABC";
        ArrayList<String> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        char[] ch = input.toCharArray();
        backtrackRecursion(input, result, s);
        System.out.println(result);
    }

    public static void backtrackRecursion(String input, ArrayList<String> result, StringBuilder s) {
        if (input.isEmpty()) {
            result.add(s.toString());
            return;
        }
        for (int i = 0 ; i < input.length();i++ ){
            Character fixed = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i+1);
            s.append(fixed);
            backtrackRecursion(remaining, result, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}

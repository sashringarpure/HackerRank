package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;

//Iterate each input digit.
//Traverse each character using for loop.
//Store it in a string builder.
//Recurse, by incrementing index, to add the next character.
//Backtrack, by removing the prior character, to cover the remaining paths.
//Base case to form a result, when the result length == length of the input digits, & to prevent index spill.

public class BacktrackingLetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String input = "23";
        HashMap<Character, String> hm = new HashMap<Character, String>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        backtrackRecursion(input, hm, result, sb, 0);
        System.out.println(result);
    }

    public static void backtrackRecursion(String input,
                                          HashMap<Character, String> hm,
                                          ArrayList<String> result, StringBuilder sb, int index) {
        //Base case to form a result, when the result length == length of the input digits, & to prevent index spill.
        if (sb.length() == input.length()){
            result.add(sb.toString());
            return;
        }
        //Iterate each input digit.
        String alphabets = hm.get(input.charAt(index));
        //Traverse each character using for loop.
        for (int i = 0; i< alphabets.length(); i++) {
            //Store it in a string builder.
            sb.append(alphabets.charAt(i));
            //Recurse, by incrementing index, to add the next character.
            backtrackRecursion(input, hm, result, sb, index+1);
            //Backtrack, by removing the prior character, to cover the remaining paths.
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

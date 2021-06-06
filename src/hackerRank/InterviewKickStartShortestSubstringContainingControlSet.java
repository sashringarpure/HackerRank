package hackerRank;

import java.util.HashSet;
import java.util.Set;

/*
First input is any string and second input is a control set, consisting of the chars found in the first input.
The objective is to find the shortest substring within the first input which contains all characters from the
control set.
 */
public class InterviewKickStartShortestSubstringContainingControlSet {

    public static void main(String[] args) {
        String input = "hello world";
        char[] inputToChar = input.toCharArray();
        Set<Character> controlSet = new HashSet<Character>();
        controlSet.add('h');
        controlSet.add('d');
        controlSet.add('e');
        Set<Character> temp = new HashSet<Character>(controlSet);
        int start = 0;
        int end = input.length() - 1 ;
        String output = new String(input);
        for ( int i = 0 ; i < inputToChar.length ; i++) {
            if ( temp.contains(inputToChar[i]) ) {
                temp.remove(inputToChar[i]);
                start = i++;
                while ( temp.size() != 0 && i < inputToChar.length ) {
                    if ( temp.contains(inputToChar[i]) ) {
                        temp.remove(inputToChar[i]);
                        i++;
                    } else {
                        i++;
                    }
                }
            }
            if ( temp.size() == 0 ) {
                end = i;
                String tempSubstring = input.substring(start,end);
                output = output.length() < tempSubstring.length() ? output : tempSubstring ;
                i = start;
                temp = new HashSet<>(controlSet);
            }
        }
        System.out.println(output);
        }
}
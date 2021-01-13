package hackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
ikikkiki:
ikikkiki
iki|kk|iki
i|k|i|kk|iki
i|kik|k|iki
iki|k|k|iki
i|k|i|k|k|iki
i|kikkik|i
i|kik|kik|i
iki|k|kik|i
i|k|i|k|kik|i
i|k|ikki|k|i
iki|kk|i|k|i
i|k|i|kk|i|k|i
i|kik|k|i|k|i
iki|k|k|i|k|i
i|k|i|k|k|i|k|i
abbaeae:
abba|eae
a|bb|a|eae
--a|b|b|a|eae
a|bb|aea|e
--a|b|b|aea|e
--abba|e|a|e
--a|bb|a|e|a|e
--a|b|b|a|e|a|e
aaaa:
aaaa
a|aaa
aa|aa
a|a|aa
aaa|a
a|aa|a
aa|a|a
a|a|a|a
 */
public class InterviewKickStartRecursionPalindromicDecompositionOfAString {

    public static void main( String[] args ) {

        String s = "acaca";
        ArrayList<String> results = new ArrayList<>();
        char[] temp = new char[2*s.length()];
        generate(s.toCharArray(), 0, temp, 0, results);
    }


   public static void generate(char[] ch, int spos, char[] temp, int tempIndex, ArrayList<String>results) {

       if ( spos == ch.length) {
           results.add(new String(temp, 0, tempIndex-1));
           System.out.println(new String(temp, 0, tempIndex-1));
           return;
       }

       for ( int i = spos; i < ch.length; i++ ) {

           int charsAppended = i - spos;
           temp[tempIndex+charsAppended] = ch[i];

           if ( isPalindrome(ch, spos, i) ) {

               temp[tempIndex+charsAppended+1] = '|';
               generate(ch, spos + charsAppended + 1, temp, tempIndex + charsAppended + 2, results);

           }
       }
   }

   public static boolean isPalindrome(char[] ch, int spos, int epos ) {

       while ( spos < epos ) {

           if ( ch[spos] != ch[epos] ) {
               return false;
           }

           spos++;
           epos--;
       }

       return true;
   }

}

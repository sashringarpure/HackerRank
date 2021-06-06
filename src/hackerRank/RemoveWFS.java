package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RemoveWFS {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        @SuppressWarnings("resource")
//        Scanner console = new Scanner(System.in);
        String inputStr = "welcome test java";
        if (inputStr.length() == 0)
        {
            System.out.println("No string entered");

        }
        else
        {
            System.out.println(inputStr);
//String newString =
            removeWord(inputStr,"test");
//System.out.println(newString);
        }

    }

    private static void removeWord(String str1, String strTemp) {
// TODO Auto-generated method stub

        List<String> al = new ArrayList<String>();
        List<String> out = new ArrayList<String>();
        al = Arrays.asList(str1.split(" "));
        for ( String s : al ) {
            if (! s.equalsIgnoreCase(strTemp)) {
                out.add(s);
                System.out.print(s + " ");
            }
        }

    }

}

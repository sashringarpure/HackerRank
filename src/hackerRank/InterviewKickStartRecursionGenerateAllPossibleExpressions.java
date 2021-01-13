package hackerRank;

import jdk.jshell.JShell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InterviewKickStartRecursionGenerateAllPossibleExpressions {

    public static void main(String[] args) {

        int[] arr = {2,2,2};
        String s = "6666666666";
        String[] op = {"()","*"};
        long target = 6;
        String [] result;
        ArrayList<String> res = new ArrayList<String>();

//        for (int i = 0; i < op.length; i++ )
//              recursion(arr, 0, op, "");
        recursion(s, 0, op, "", target, res);
        for (String o : res)
            System.out.println(o);
//        result = new String[res.size()];
//        result = res.toArray(result);

    }

    public static void recursion(String s, int index, String[] op, String slate, long target, ArrayList<String> res) {

        if ( index == (s.length()-1) ) {
            slate = slate + s.substring(index); //evaluate the slate
            slate = slate.replaceAll("\\(","").replaceAll("\\)","");
            String origExpr = slate;
            System.out.println("slate expression:" + slate);
            slate = eval(slate,"*");
            slate = eval(slate,"+");
            if ( Long.parseLong(slate) == target )
                res.add(origExpr);
            System.out.println("slate value:" + slate);
            System.out.println("slate List:" + res);
        }
        else {
            for (int i = 0; i <= op.length-1; i++ ) {
                recursion(s, index+1,op,slate + s.substring(index, index+1) + op[i], target, res);
            }
        }

    }

    public static String eval(String slate, String op) {

        if ( slate.contains(op) ) {

            int index = slate.indexOf(op);
            if ( index > 0 ) {
                int leftCounter = index - 1;
                Long result = 0L;
                while ( slate.substring(leftCounter-1 > 0 ? leftCounter-1 : leftCounter,index).chars().allMatch(Character::isDigit) && leftCounter >= 1 ) { leftCounter = leftCounter - 1;}
                Long leftOperand = Long.parseLong(slate.substring(leftCounter,index));
                int rightCounter = index+1;
                while ( slate.substring(index+1,rightCounter).chars().allMatch(Character::isDigit) && rightCounter <= slate.length()-1 ) {rightCounter = rightCounter + 1;}
                Long rightOperand = 0L;
                if ( rightCounter > slate.length() - 1 )
                    rightOperand = Long.parseLong(slate.substring(index+1));
                else
                    rightOperand = Long.parseLong(slate.substring(index+1,--rightCounter));
                switch (op) {
                    case "*":
                        result = leftOperand*rightOperand;
                        break;
                    case "+":
                        result = leftOperand+rightOperand;
                        break;
                }

//                slate = slate.replace(slate.substring(Math.max(leftCounter,0),rightCounter),Integer.toString(result));
                slate = slate.replaceFirst(Pattern.quote(slate.substring(leftCounter,rightCounter)),Long.toString(result));
                System.out.println("slate recursion :" + slate);
            }
            return eval(slate,op);
        } else {
            return slate;
        }

    }


}

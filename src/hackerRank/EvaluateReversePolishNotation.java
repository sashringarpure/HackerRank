import java.util.Stack;
/*
Logic:
Traverse the array.
Write a switch statement.
If the array element is an operand, pop the last two elements and evaluate. Push the result to the stack.
If the array element is a value, push the value to the stack.
Features:
Array
Stack: Stack<String> stack = new Stack<String>(); stack.push(String.valueOf(result)); stack.pop();
Conversion: Integer.parseInt(a), String.valueOf(result)
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] input = {"4", "13", "5", "/", "+"};
        //String[] input = {"4", "13", "+"};
        String a = "";
        String b = "";
        int result = 0;
        String temp = "";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < input.length ; i++ ) {
            temp = input[i];
            switch(temp){
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    result = Integer.parseInt(a) + Integer.parseInt(b);
                    stack.push(String.valueOf(result));
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    result = Integer.parseInt(b) / Integer.parseInt(a);
                    stack.push(String.valueOf(result));
                    break;
                default:
                    stack.push(input[i]);
                    break;
            }
        }
        System.out.println(result);
    }
}

package hackerRank;

public class EvaluateStringExpression {

    public static void main(String[] args) {
        String expr = "{ ((5+4) - (1+1)) * [(6+4) + (1+1)] }";
        //String expr = "{7*12}";
        expr = expr.replaceAll(" ","");
        char[] exprToChar = expr.toCharArray();
        int openIndex = 0 ;
        char openBrace = ' ';
        String operator = "";
        int leftOperand = 0;
        int rightOperand = 0;
        int temp = 0;
        for (int i = 0 ; i < exprToChar.length ; i++ ) {
            if ( exprToChar[i] == '{' || exprToChar[i] == '(' || exprToChar[i] == '[') {
                openIndex = i;
                openBrace = exprToChar[i];
            } else if ( ( openBrace == '{' && exprToChar[i] == '}' ) ||
                    ( openBrace == '(' && exprToChar[i] == ')' )     ||
                    ( openBrace == '[' && exprToChar[i] == ']' )   ) {
                temp = openIndex+1;
                while ( temp != i ) {
                    if ( ! Character.isDigit(exprToChar[temp]) ) {
                        leftOperand = Integer.parseInt(expr.substring(openIndex+1,temp));
                        rightOperand = Integer.parseInt(expr.substring(temp+1,i));
                        operator = expr.substring(temp, temp+1);
                        break;
                    }
                    temp++;
                }
                switch (operator) {
                    case "+":
                        temp = leftOperand + rightOperand;
                        break;
                    case "-":
                        temp = leftOperand - rightOperand;
                        break;
                    case "*":
                        temp = leftOperand * rightOperand;
                        break;
                }
                expr = expr.substring(0,openIndex) + String.valueOf(temp) + expr.substring(i+1);
                System.out.println(expr);
                exprToChar = expr.toCharArray();
                i=-1;
            }
        }
    }
}

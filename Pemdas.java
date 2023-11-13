import MyPemdasFiles.*;
import MyPemdasFiles.MyOperations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Pemdas {
    private Stack<Integer> stack;
    private Map<Character, DoOperation> operations;

    public Pemdas(){
        stack = new Stack<>();
        operations = new HashMap<>();
        operations.put('+', new DoAddition());
        operations.put('-', new DoSubtraction());
        operations.put('/', new DoDivision());
        operations.put('*', new DoMultiplication());
        operations.put('^', new DoPower());
        operations.put('%', new DoModulo());
    }

    public int evaluateExpression(Expression e){
        if(e.getExpressionType() == ExpressionType.POSTFIX){
            System.out.println("Solving Postfix expression ");
            return Calculate(e.getExpression(), Convert.TO_POSTFIX);
        }
        else{
            System.out.println("Solving Prefix expression ");
            StringBuilder reversed = new StringBuilder(e.getExpression());
            return Calculate(reversed.reverse().toString(), Convert.TO_PREFIX);
        }
    }

    private int Calculate(String s, Convert convertType){
        stack.clear();
        boolean hasNum = false;
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(character == '_') {
                hasNum = false;
            }
            else if(operations.containsKey(character)){
                printExpression(s.substring(i), convertType);
                operations.get(character).evaluate(stack, convertType);
                hasNum = false;
            } 
            else{
                if(hasNum == true){
                    stack.push(stack.pop() * 10 + Integer.parseInt(String.valueOf(character)) );
                }
                else{
                    stack.push( Integer.parseInt(String.valueOf(character)) );
                    hasNum = true;
                }
            }

        }
        return stack.peek();
    }

    private void printExpression(String subString, Convert convertType){
        String thisExpression = subString;
        thisExpression = thisExpression.replace("_", " ");
        StringBuilder expression = new StringBuilder();
        for(int i : stack){
            expression.append(i + " ");
        }
        expression.append(thisExpression);
        if(convertType == Convert.TO_PREFIX){
            System.out.println("    " + expression.reverse().toString());
        }
        else{
            System.out.println("    " + expression.toString());
        }
    }
}
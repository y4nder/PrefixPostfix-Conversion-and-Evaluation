
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import MyPemdasFiles.*;
import MyPemdasFiles.MyOperations.*;

public class Pemdas {
    private Stack<String> stack;
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

    public String evaluateExpression(Expression e){
        if(e.getExpressionType() == ExpressionType.POSTFIX){
            System.out.println("Solving Postfix expression ");
            return Calculate(e.getExpression(), e.hasDecimal());
        }
        else{
            System.out.println("Solving Prefix expression ");
            StringBuilder reversed = new StringBuilder(e.getExpression());
            return Calculate(reversed.reverse().toString(), e.hasDecimal());
        }
    }


    private String Calculate(String s, boolean hasDecimal){
        stack.clear();
        boolean hasNum = false;
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(character == '_') {
                hasNum = false;
            }
            else if(operations.containsKey(character)){
                try{
                    operations.get(character).evaluate(stack, hasDecimal);
                }
                catch(Exception e){
                    System.out.println("invalid expression");
                    return null;
                }

                hasNum = false;
            } 
            else{
                if(hasNum == true){
                    stack.push(stack.pop().concat(String.valueOf(character)));
                }
                else{
                    stack.push(String.valueOf(character));
                    hasNum = true;
                }
            }

        }
        return stack.peek();
    }
}
import MyPemdasFiles.*;
import MyPemdasFiles.MyOperations.*;
import java.util.HashMap;
import java.util.Map;

public class Pemdas {
    private CustomIntegerStack stack;
    private Map<Character, DoOperation> operations;

    public Pemdas(){
        stack = new CustomIntegerStack();
        operations = new HashMap<>();
        operations.put('+', new DoAddition());
        operations.put('-', new DoSubtraction());
        operations.put('/', new DoDivision());
        operations.put('*', new DoMultiplication());
        operations.put('^', new DoPower());
        operations.put('%', new DoModulo());
        operations.put('u', new DoUnaryMinus());
    }

    public int solvePostFix(String s){
        //conversion to postFix
        return Calculate(s, false);
    }

    public int solvePrefix(String s){
        StringBuilder reversed = new StringBuilder(s);
        return Calculate(reversed.reverse().toString(), true);
    }

    private int Calculate(String s, boolean fromPrefix){
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(operations.containsKey(character)){
                operations.get(character).evaluate(stack, fromPrefix);
                stack.setHasNum(false);
            } 
            else{
                if(stack.HasNum() == true){
                    stack.push(stack.pop() * 10 + Integer.parseInt(String.valueOf(character)) );
                }
                else{
                    stack.push( Integer.parseInt(String.valueOf(character)) );
                }
            }

        }
        return stack.peek();
    }
}
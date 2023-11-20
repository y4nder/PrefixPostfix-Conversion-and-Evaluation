package MyPemdasFiles.MyOperations;
import java.util.Stack;

import MyPemdasFiles.DoOperation;

public class DoPower implements DoOperation{

    // @Override
    // public void evaluate(Stack<Integer> stack, Convert convertType) {
    //     int a, b, result;
    //     a = stack.pop();
    //     b = stack.pop();
    //     if(convertType == Convert.TO_PREFIX){
    //         result = a;
    //         for(int i = 1; i < b; i++){
    //             result *= a;
    //         }
    //         // System.out.println("    " + a + " ^ " + b + " = " + result);
    //     }
    //     else{
    //         result = b;
    //         for(int i = 1; i < a; i++){
    //             result *= b;
    //         }
    //         // System.out.println("    " + b + " ^ " + a + " = " + result);
    //     }
    //     stack.push(result);    
    // }

    @Override
    public void evaluate(Stack<String> stack, boolean hasDecimal) {
        int result = 0;
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());
        result = b;
        for(int i = 1; i < a; i++){
            result *= b;
        }
        stack.push(String.valueOf(result));
    }
}

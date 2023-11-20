package MyPemdasFiles.MyOperations;
import java.util.Stack;

import MyPemdasFiles.DoOperation;

public class DoDivision implements DoOperation{

    // @Override
    // public void evaluate(Stack<Integer> stack, Convert convertType) {
    //     int a, b, result;
    //     a = stack.pop();
    //     b = stack.pop();
    //     if(convertType == Convert.TO_PREFIX){
    //         result = a / b;
    //         // System.out.println("    " + a + " / " + b + " = " + result);
    //     }
    //     else{            
    //         result = b / a;
    //         // System.out.println("    " + b + " / " + a + " = " + result);
    //     }
    //     stack.push(result);    
    // }

    @Override
    public void evaluate(Stack<String> stack, boolean hasDecimal) {
        double result = 0.0;
        double a = Double.parseDouble(stack.pop());
        double b = Double.parseDouble(stack.pop());
        result = b / a;
        stack.push(String.valueOf(result));  
    }
}

package MyPemdasFiles.MyOperations;
import java.util.Stack;

import MyPemdasFiles.DoOperation;
public class DoAddition implements DoOperation{

    @Override
    public void evaluate(Stack<String> stack, boolean hasDecimal) {
        if(hasDecimal){
            double result = 0.0;
            double a = Double.parseDouble(stack.pop());
            double b = Double.parseDouble(stack.pop());
            result = b + a;
            stack.push(String.valueOf(result));  
        }else{
            int result = 0;
            int a = Integer.parseInt(stack.pop());
            int b = Integer.parseInt(stack.pop());
            result = b + a;
            stack.push(String.valueOf(result));
        }
    }  
}

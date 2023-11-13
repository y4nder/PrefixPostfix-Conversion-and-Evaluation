package MyPemdasFiles.MyOperations;
import java.util.Stack;

import MyPemdasFiles.DoOperation;
import MyPemdasFiles.Convert;

public class DoAddition implements DoOperation{

    public void evaluate(Stack<Integer> stack, Convert convertType) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        if(convertType == Convert.TO_PREFIX){
            result = a + b;
            // System.out.println("    " + a + " + " + b + " = " + result);
        }
        else{
            result = b + a;
            // System.out.println("    " + b + " + " + a + " = " + result);
        }
        stack.push(result);  
    }  
}

package MyPemdasFiles.MyOperations;
import MyPemdasFiles.CustomIntegerStack;
import MyPemdasFiles.DoOperation;

public class DoPower implements DoOperation{

    @Override
    public void evaluate(CustomIntegerStack stack) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b;
        for(int i = 1; i < a; i++){
            result *= b;
        }
        System.out.println("    " + b + " ^ " + a + " = " + result);
        stack.push(result);    
    }
}

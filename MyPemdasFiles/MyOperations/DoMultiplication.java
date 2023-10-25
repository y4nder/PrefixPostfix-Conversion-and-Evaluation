package MyPemdasFiles.MyOperations;
import MyPemdasFiles.CustomIntegerStack;
import MyPemdasFiles.DoOperation;

public class DoMultiplication implements DoOperation{

    @Override
    public void evaluate(CustomIntegerStack stack) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        result = b * a;
        System.out.println("    " + b + " * " + a + " = " + result);
        stack.push(result);     
    }
}

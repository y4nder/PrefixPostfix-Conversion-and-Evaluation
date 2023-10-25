package MyPemdasFiles.MyOperations;
import MyPemdasFiles.CustomIntegerStack;
import MyPemdasFiles.DoOperation;

public class DoUnaryMinus implements DoOperation{

    public void evaluate(CustomIntegerStack stack) {
        int a, result;
        a = stack.pop();
        result = a * (-1);
        System.out.println("(-) " + a + " = " + result);
        stack.push(result);
    }
}

package MyPemdasFiles.MyOperations;
import MyPemdasFiles.CustomIntegerStack;
import MyPemdasFiles.DoOperation;

public class DoMultiplication implements DoOperation{

    @Override
    public void evaluate(CustomIntegerStack stack, boolean prefix) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        if(prefix){
            result = a * b;
            System.out.println("    " + a + " * " + b + " = " + result);
        }
        else{
            result = b * a;
            System.out.println("    " + b + " * " + a + " = " + result);
        }
        stack.push(result);     
    }
}

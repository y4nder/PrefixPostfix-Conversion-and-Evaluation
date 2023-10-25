package MyPemdasFiles.MyOperations;
import MyPemdasFiles.CustomIntegerStack;
import MyPemdasFiles.DoOperation;

public class DoPower implements DoOperation{

    @Override
    public void evaluate(CustomIntegerStack stack, boolean prefix) {
        int a, b, result;
        a = stack.pop();
        b = stack.pop();
        if(prefix){
            result = a;
            for(int i = 1; i < b; i++){
                result *= a;
            }
            System.out.println("    " + a + " ^ " + b + " = " + result);
        }
        else{
            result = b;
            for(int i = 1; i < a; i++){
                result *= b;
            }
            System.out.println("    " + b + " ^ " + a + " = " + result);
        }
        stack.push(result);    
    }
}

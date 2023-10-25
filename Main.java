import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = scan.nextLine();

        PostFixConverter postFix = new PostFixConverter();
        String postFixed = postFix.convertToPostFix(expression);

        PreFixConverter prefix = new PreFixConverter();
        String prefixed = prefix.convertToPreFix(expression);

        System.out.println("Expression: " + expression);
        
        Pemdas pemdas = new Pemdas();
        
        System.out.println("postfixed: " + postFixed);
        int totalPostfix = pemdas.solvePostFix(postFixed);
        System.out.println("Total of postfix expression: " + totalPostfix);
        
        System.out.println("Prefixed: " + prefixed);
        int totalPrefix = pemdas.solvePrefix(prefixed);
        System.out.println("Total of prefix expression: " + totalPrefix);

    }
}
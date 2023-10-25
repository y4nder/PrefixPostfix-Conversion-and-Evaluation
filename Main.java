import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ex: 22 + 2*2 / 2 ^ 2 * 2");
        System.out.print("Enter expression: ");
        String expression = scan.nextLine();

        PostFixConverter postFix = new PostFixConverter();
        String postFixed = postFix.convertToPostFix(expression);

        PreFixConverter prefix = new PreFixConverter();
        String prefixed = prefix.convertToPreFix(expression);

        Pemdas pemdas = new Pemdas();
        
        print("\npostfixed: ", postFixed);
        int totalPostfix = pemdas.solvePostFix(postFixed);
        System.out.println("Total of postfix expression: " + totalPostfix);
        
        print("\nPrefixed: ", prefixed);
        int totalPrefix = pemdas.solvePrefix(prefixed);
        System.out.println("Total of prefix expression: " + totalPrefix);

    }

    public static void print(String instruction, String expression){
        char x = '_';
        while(true){
            int indexOfX = expression.indexOf(x);
            if(indexOfX > -1){
                expression = expression.substring(0, indexOfX) + expression.substring( indexOfX + 1);
            }
            else break;
        }
        System.out.println(instruction + expression);
    }
}
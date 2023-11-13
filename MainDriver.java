import java.util.Scanner;

public class MainDriver {
    public static void main(String[] args) {
        
        //user input for expression
        Scanner scan = new Scanner(System.in);
        System.out.println("Ex: 22 + 2*2 / 2 ^ 2 * 2");
        System.out.print("Enter expression: ");
        String expression = scan.nextLine();
        
        //expression converting
        ExpressionConverter expConverter = new ExpressionConverter();
        Expression postfixed = expConverter.toPostFix(expression);
        Expression prefixed = expConverter.toPrefix(expression);
        System.out.println("Postfixed: " + postfixed);
        System.out.println("Prefixed: " + prefixed);
        
        //expression evaluation
        Pemdas p = new Pemdas();
        System.out.println("total of Postfix: " + p.evaluateExpression(postfixed));
        System.out.println("total of Postfix: " + p.evaluateExpression(prefixed));
        scan.close();
    }
}

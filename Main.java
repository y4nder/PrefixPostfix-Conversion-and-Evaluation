import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ExpressionConverter expConverter = new ExpressionConverter();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ex: 22 + 2*2 / 2 ^ 2 * 2");
        System.out.print("Enter expression: ");
        String expression = scan.nextLine();

        Expression postfixed = expConverter.toPostFix(expression);
        Expression prefixed = expConverter.toPrefix(expression);

        postfixed.show();
        prefixed.show();
        
        Pemdas p = new Pemdas();
        System.out.println("total of Postfix: " + p.evaluateExpression(postfixed));
        System.out.println("total of Postfix: " + p.evaluateExpression(prefixed));
        scan.close();
    }
}

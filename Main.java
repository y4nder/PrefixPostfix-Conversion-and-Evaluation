import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = scan.nextLine();
        PostFixConverter postFix = new PostFixConverter();
        String postFixed = postFix.convertToPostFix(expression);
        System.out.println("Expression: " + expression);
        System.out.println("postfixed: " + postFixed);

        Pemdas pemdas = new Pemdas();
        int total = pemdas.Calculate(postFixed);

        System.out.println("Total: " + total);

    }
}
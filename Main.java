public class Main{
    public static void main(String[] args){
        String expression = "3 + 2 + (2 + 1) / 2 * 3 + 1";
        PostFixConverter postFix = new PostFixConverter();
        PreFixConverter preFix = new PreFixConverter();
        PostToInfix infix = new PostToInfix();
        System.out.println("Expression: " + expression);
        System.out.println("postfixed: " + postFix.convertToPostFix(expression));
        System.out.println("prefixed: " + preFix.convertToPreFix(expression));
        System.out.println("infixed from postFix: " + infix.convertToInfix(postFix.convertToPostFix(expression)));
    }
}
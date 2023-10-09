public class Main{
    public static void main(String[] args){
        String expression = "( (12 * 2 + 5) / (7 - 3) ) * ( (8 / 2) + (6 ^ 2) )";
        PostFixConverter postFix = new PostFixConverter();
        PreFixConverter preFix = new PreFixConverter();
        System.out.println("infixed: " + expression);
        System.out.println("postfixed: " + postFix.convertToPostFix(expression));
        System.out.println("prefixed: " + preFix.convertToPreFix(expression));
    }

}
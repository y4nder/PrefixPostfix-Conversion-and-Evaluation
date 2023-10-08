public class Main{
    public static void main(String[] args){
        String expression = "(2+3-1)*3";
        PostFixConverter postFix = new PostFixConverter();
        PreFixConverter preFix = new PreFixConverter();
        System.out.println("infixed: " + expression);
        System.out.println("postfixed: " + postFix.convertToPostFix(expression));
        System.out.println("prefixed: " + preFix.convertToPreFix(expression));
    }

}
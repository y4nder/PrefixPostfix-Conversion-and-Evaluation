public class Test{
    public static void main(String[] args){
        String expression = "(2+3-1)*3";
        PostFixConverter postFix = new PostFixConverter();
        PreFixConverter preFix = new PreFixConverter();

        System.out.println(postFix.convertToPostFix(expression));
        System.out.println(preFix.convertToPreFix(expression));
    }

}
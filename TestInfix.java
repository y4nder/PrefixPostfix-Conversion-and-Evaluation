public class TestInfix {
    public static void main(String[] args){
        PostToInfix p = new PostToInfix();

        String exp = "22*5+73-/82/62^+*";

        System.out.println(p.convertToInfix(exp));
    }
}

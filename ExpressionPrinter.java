public class ExpressionPrinter {
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

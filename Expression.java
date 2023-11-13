import MyPemdasFiles.ExpressionType;

public class Expression {
    private final String expression;
    private final ExpressionType expressionType;

    public Expression(String expression, ExpressionType expressionType) {
        this.expression = expression;
        this.expressionType = expressionType;
    }

    public String getExpression() {
        return expression;
    }
    
    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void show(){
        System.out.println(expressionType);
        String printedExpression = expression;
        char x = '_';
        while(true){
            int indexOfX = printedExpression.indexOf(x);
            if(indexOfX > -1){
                printedExpression = printedExpression.substring(0, indexOfX) + printedExpression.substring( indexOfX + 1);
            }
            else break;
        }
        System.out.println(printedExpression);
    }

}

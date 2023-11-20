import MyPemdasFiles.ExpressionType;

public class Expression {
    private final String expression;
    private final ExpressionType expressionType;
    private boolean hasDecimal;

    public Expression(String expression, ExpressionType expressionType, boolean hasDecimal) {
        this.expression = expression;
        this.expressionType = expressionType;
        this.hasDecimal = hasDecimal;
    }

    public String getExpression() {
        return expression;
    }
    
    public ExpressionType getExpressionType() {
        return expressionType;
    }
    
    public boolean hasDecimal(){
        return hasDecimal;
    }

    public String toString(){
        String printedExpression = expression;
        // char x = '_';
        // while(true){
        //     int indexOfX = printedExpression.indexOf(x);
        //     if(indexOfX > -1){
        //         printedExpression = printedExpression.substring(0, indexOfX) + printedExpression.substring( indexOfX + 1);
        //     }
        //     else break;
        // }
        System.out.println("has decimal " + hasDecimal);
        return printedExpression;
    }

}


import java.util.Stack;

import MyPemdasFiles.ExpressionType;

public class ExpressionConverter {
    private StringBuilder convertedExpression;
    private Stack<Character> stack;
    
    private boolean isIntOrDecimal = false;

    public Expression toPostFix(String expression){
        String postfixed = dynamicConverter(expression, ExpressionType.POSTFIX); 
        return new Expression(postfixed, ExpressionType.POSTFIX, isIntOrDecimal);
    }

    public Expression toPrefix(String expression){
        convertedExpression = new StringBuilder(expression);
        interChangeParentheses(convertedExpression);
        convertedExpression.reverse();
        String postFixedExpression = dynamicConverter(convertedExpression.toString(), ExpressionType.PREFIX);
        convertedExpression.replace(0, convertedExpression.length(), postFixedExpression);
        convertedExpression.reverse();
        return new Expression(convertedExpression.toString(), ExpressionType.PREFIX, isIntOrDecimal);
    }

    private String dynamicConverter(String expression, ExpressionType expressionType){
        convertedExpression = new StringBuilder();
        stack = new Stack<>();
        char previous = '_';
        expression += ')';
        stack.push('(');
        for(int i = 0; i < expression.length(); i++){
            char character = expression.charAt(i);
            switch(character){
                case ' ':
                    break;
                case '(':
                    if(isParenthesesMultiplication(previous) ){ // added multiplication using parentheses
                        addToExpression('_'); //separator from operator
                        stack.push('*');
                    }
                    stack.push(character);
                    break;
                case ')':
                    while(stack.peek() != '('){
                        addToExpression(stack.pop());
                    }
                    stack.pop();
                    break;
                default: 
                    if(isNumber(character)){
                        addToExpression(character);
                    }
                    else if(isUnaryMinusOperator(character, previous) ){ //check for unary minus
                        stack.push('u');          
                    }
                    else if(character == '.'){
                        addToExpression(character);
                        isIntOrDecimal = true;
                    }
                    else{
                        addToExpression('_'); //separator
                        if(character == '/') isIntOrDecimal = true;
                        if(expressionType == ExpressionType.PREFIX){
                            while(checkPrecedence(stack.peek()) > checkPrecedence(character) ){
                                addToExpression(stack.pop());
                            }
                        }
                        else{
                            while(checkPrecedence(stack.peek()) >= checkPrecedence(character) ){
                                addToExpression(stack.pop());
                            }
                        }
                        stack.push(character);
                    }
                    break;
                }
            
                if(character == ' ') previous = expression.charAt(i - 1);
                else previous = character;
        }

        while(!stack.isEmpty()){
            addToExpression(stack.pop());
        }

        return convertedExpression.toString();
    }

    private void addToExpression(char character){
        convertedExpression.append(character);
    }

    private boolean isNumber(char character){
        return Character.isDigit(character);
    }

    private int checkPrecedence(char character){
        switch(character){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case 'u':
                return 3;
            case '^':
                return 4;
        }
        return 0;
    }

    private void interChangeParentheses(StringBuilder expression){
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '('){
                expression.setCharAt(i, ')');
                i++;
            }
            if(expression.charAt(i) == ')'){
                expression.setCharAt(i, '(');
                i++;
            }
        }
    }

    //private methods
    private boolean isParenthesesMultiplication(char character){ // method to check if multiplication by parentheses is true
        if(isNumber(character) || character == ')') return true;
        else return false;
    }

    private boolean isUnaryMinusOperator(char character, char previous){ //method to check if unary minus opration is true
        if( character == '-' && (previous == '_' || previous == '(' || checkPrecedence(previous) > 0) ) return true;
        else return false;
    }

    public static void main(String[] args) {
        ExpressionConverter ec = new ExpressionConverter();
        String s = "2(2)";
        Expression e = ec.toPostFix(s);
        System.out.println(e);

    }
}

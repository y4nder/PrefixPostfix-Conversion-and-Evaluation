import java.util.Stack;

import MyPemdasFiles.ExpressionType;

public class ExpressionConverter {
    private StringBuilder convertedExpression;
    private Stack<Character> stack;

    public Expression toPostFix(String expression){
        String postfixed = dynamicConverter(expression, ExpressionType.POSTFIX); 
        return new Expression(postfixed, ExpressionType.POSTFIX);
    }

    public Expression toPrefix(String expression){
        convertedExpression = new StringBuilder(expression);
        interChangeParentheses(convertedExpression);
        convertedExpression.reverse();
        String postFixedExpression = dynamicConverter(convertedExpression.toString(), ExpressionType.PREFIX);
        convertedExpression.replace(0, convertedExpression.length(), postFixedExpression);
        convertedExpression.reverse();
        return new Expression(convertedExpression.toString(), ExpressionType.PREFIX);
    }

    private String dynamicConverter(String expression, ExpressionType expressionType){
        convertedExpression = new StringBuilder();
        stack = new Stack<>();

        expression += ')';
        stack.push('(');
        for(int i = 0; i < expression.length(); i++){
            char character = expression.charAt(i);
            switch(character){
                case ' ':
                    break;
                case '(':
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
                    else{
                        addToExpression('_'); //separator
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
            case '^':
                return 3;
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
}

import java.util.Stack;

public class PostToInfix extends OperatorPrecedence {
    private StringBuilder infixedExpression;
    private Stack<String> stack;

    public PostToInfix(){
        this.infixedExpression = new StringBuilder();
        this.stack = new Stack<>();
    }

    public String convertToInfix(String expression){
        for(int i = 0; i < expression.length(); i++){
            char character = expression.charAt(i);
            if(character == ' ') continue;
            if(isNumber(character)){
                stack.add(String.valueOf(character));
            }
            else{
                String operand2 = stack.pop();
                if(operand2.length() > 1){
                    operand2 = "(" + operand2 + ")";
                }

                String operand1 = stack.pop();
                if(operand1.length() > 1 && i != expression.length()-1){
                    operand1 = "(" + operand1 + ")";
                }

                stack.push( operand1 + character + operand2);
            }
        }

        while(!stack.isEmpty()){
            infixedExpression.append(stack.pop());
        }
        
        return infixedExpression.toString();
    }
}

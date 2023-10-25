/**
 * Step 1: Reverse the infix string. Note that while reversing the string you must interchange left and right parentheses.
 * Step 2: Obtain the postfix expression of the expression obtained from Step 1 using the above given postfix 
 *          algorithm with slight change in Step 3.4
 *          IF an operator O is encountered, then
 *          a. Repeatedly pop from stack and add each operator ( popped from the stack) 
 *              to the postfix expression which has equal or higher precedence than O
 * Step 3: Reverse the postfix expression to get the prefix expression
 */

public class PreFixConverter{
    
    public String convertToPreFix(String expression){
        PostFixConverter converter = new PostFixConverter();
        StringBuilder preFixedExpression = new StringBuilder(expression);
        interChangeParentheses(preFixedExpression);
        preFixedExpression.reverse();
        String postFixedExpression = converter.convertToPostFixThePrefix(preFixedExpression.toString());
        preFixedExpression.replace(0, preFixedExpression.length(), postFixedExpression);
        preFixedExpression.reverse();
        return preFixedExpression.toString();
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

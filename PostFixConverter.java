import java.util.Stack;

/**
 * Step 1: Add ")" to the end of the infix expression
 * Step 2: Push "(" onto the stack
 * Step 3: Repeat until each character in the infix notation is scanned
 *      3.1: IF a "(" is encountered, push it on the stack
 *      3.2: IF an operand ( whether a digit or a character) 
 *            is encountered, add it postfix expression.
 *      3.3: IF a ")" is encountered, then
 *              a. Repeatedly pop from stack and add it to the postfix expression until a "(" is encountered.
 *              b. Discard the "(". That is, remove the(from stack and do not add it to the postfix expression
 *      3.4: IF an operator O is encountered, then
 *              a. Repeatedly pop from stack and add each operator ( popped from the stack) 
 *              to the postfix expression which has equal or higher precedence than O
 *              b. Push the operator O to the stack.
 * [END OF IF]
 * Step 4: Repeatedly pop from the stack and add it to the postfix expression until the stack is empty
 * Step 5: EXIT  
 */

public class PostFixConverter extends OperatorPrecedence{
    private StringBuilder postFixed;
    private Stack<Character> stack;
    private boolean fromPrefix = false;

    public String convertToPostFixThePrefix(String expression){
        fromPrefix = true;
        return convertToPostFix(expression);
    }

    public String convertToPostFix(String expression){
        postFixed = new StringBuilder();
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
                        if(fromPrefix){
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
        
        return postFixed.toString();
    }

    private boolean isNumber(char character){
        return Character.isDigit(character);
    }

    private void addToExpression(char character){
        postFixed.append(character);
    }
}


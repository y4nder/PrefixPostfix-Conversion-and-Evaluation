public class OperatorPrecedence {
    public int checkPrecedence(char character){
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
}

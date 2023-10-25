package MyPemdasFiles;
public class CustomIntegerStack {
    private int[] stack;
    private int top;
    private boolean isNum;

    public CustomIntegerStack(){
        stack = new int[50];
        top = -1;
        isNum = false;
    }

    //special case
    public void setHasNum(boolean x){
        isNum = x;
    }

    public boolean HasNum(){
        return isNum;
    }

    public void push(int x){
        stack[++top] = x;
    }

    public int pop(){
        if(top == -1){
            return 0;
        }
        return stack[top--];
    }
    
    public int peek(){
        return stack[top];
    }
}
package pl.kuczu.abstractDataType.arrays;

public class stackArray {
    private int maxSize;
    private long stack[];
    private int top;

    public stackArray(int maxSize) {
        this.maxSize = maxSize;
        stack = new long[maxSize];
        top = maxSize;
    }

    public boolean isFull(){
        return top == 0;
    }

    public boolean isEmpty(){
        return top == maxSize;
    }

    public void push(long value){
        if(isFull()){
            System.out.println("Stos jest pełny!");
        }
        else{
            top--;
            stack[top] = value;
        }
    }

    public long pop(){
        if(isEmpty()){
            System.out.println("Stos jest pusty!");
            return -1;
        }

        return stack[top++];
    }
}

package pl.kuczu.abstractDataType.linked;

public class StackConstOperations {
    private ExtendedLink top;

    public StackConstOperations() {
        this.top = null;
    }

    public void push(int value){ //TODO
        ExtendedLink newNode = new ExtendedLink(value);

        if(top == null){ // empty stack
            top = newNode;
        }
        else{
            ExtendedLink orderNode = top.min; //min/max

            if(value < orderNode.value){
                newNode.min = newNode; // no needed, it is in constructor, added so it's easier to understand the idea
            }
            else{
                newNode.min = orderNode;
            }

            orderNode = top.max;

            if(value > orderNode.value){
                newNode.max = newNode; // no needed, it is in constructor, added so it's easier to understand the idea
            }
            else{
                newNode.max = orderNode;
            }

            newNode.prev = top;
            top = newNode;
        }
    }

    public ExtendedLink pop(){
        ExtendedLink returnNode = top;
        top = top.prev;

        return returnNode;
    }

    public ExtendedLink top(){
        return top;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int findMin(){
        return top.min.value;
    }

    public int findMax(){
        return top.max.value;
    }

    public void printStack(){
        ExtendedLink node = top;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String args[]){
        StackConstOperations stack = new StackConstOperations();

        for(int i = 1; i <= 10; i++){
            stack.push(i);
            stack.push(i + 50);
        }

        stack.printStack();
        System.out.println("Max: " + stack.findMax() + "\nMin: " + stack.findMin());

        for(int i = 100; i > 85; i--){
            stack.push(i);
        }

        stack.printStack();
        System.out.println("Max: " + stack.findMax() + "\nMin: " + stack.findMin());
    }
}

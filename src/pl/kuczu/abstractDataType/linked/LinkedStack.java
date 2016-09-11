package pl.kuczu.abstractDataType.linked;

public class LinkedStack {
    private Link top; // use ONLY next from Link class

    public LinkedStack() {
        this.top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int value){
        Link newNode = new Link(value);
        newNode.next = top;
        top = newNode;
    }

    public int top(){
        return top.value;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stos jest pusty!");
            return -1;
        }

        int returnValue = top.value;
        top = top.next;

        return returnValue;
    }

    public void displayStack(){
        if(isEmpty()){
            System.out.println("Stos jest pusty!");
            return;
        }

        Link node = top;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
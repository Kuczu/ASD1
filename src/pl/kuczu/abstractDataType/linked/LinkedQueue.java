package pl.kuczu.abstractDataType.linked;

public class LinkedQueue { // FIFO
    private Link front;
    private Link rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){
        return (front == null || rear == null);
    }

    public void enQueue(int value){
        if(isEmpty()){
            front = new Link(value);
            rear = front;
        }
        else{
            rear.next = new Link(value);
            rear = rear.next;
        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("Kolejka jest pusta!");
            return -1; // exception need
        }
        else{
            int returnValue = front.value;
            front = front.next;

            return returnValue;
        }
    }

}
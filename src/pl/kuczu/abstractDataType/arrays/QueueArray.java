package pl.kuczu.abstractDataType.arrays;

public class QueueArray { //FIFO
    private int maxSize;
    private long queue[];
    private int front;
    private int rear;

    public QueueArray(int maxSize){
        this.maxSize = maxSize;
        queue = new long[maxSize];
        front = 0;
        rear = 0;
    }

    private int position(int idx){
        return (idx + 1) % maxSize;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public boolean isFull(){
        return position(rear) == front;
    }

    public void enQueue(long value){ // push
        if(isFull()){
            System.out.println("Kolejka jest pełna!");
        }
        else{
            queue[rear] = value;
            rear = position(rear);
        }
    }

    public long deQueue(){ // pop
        if(isEmpty()){
            System.out.println("Kolejka jest pusta!");
            return -1;
        }

        long tmp = queue[front];
        front = position(front);
        return tmp;
    }

    public long front(){
        if(isEmpty()){
            System.out.println("Kolejka jest pusta!");
            return -1;
        }

        return queue[front];
    }
}

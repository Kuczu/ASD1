package pl.kuczu.abstractDataType.linked;

//double linked list, without head and tail, is not cycle ll
public class LinkedList {
    private Link first;
    private Link last;
    private Boolean isReversed;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.isReversed = false;
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void reverseList(){ // reversing at O1
        isReversed = true;

        Link nodeBuff = first;
        first = last;
        last = nodeBuff;
    }

    private void insertFirstMethod(int val, Link first){
        Link newNode = first;

        first = new Link(val);

        first.next = newNode;

        if(last == null){
            last = first;
        }
        else{
            newNode.prev = first;
        }
    }

    private void insertLastMethod(int val, Link last){
        Link newNode = last;

        last = new Link(val);

        last.prev = newNode;

        if(first == null){
            first = last;
        }
        else{
            newNode.next = last;
        }
    }

    public void insertFirst(int val){
        if(!isReversed){
            insertFirstMethod(val, first);
        }
        else{
            insertLastMethod(val, first);
        }
    }

    public void insertLast(int val){
        if(!isReversed){
            insertLastMethod(val, last);
        }
        else{
            insertFirstMethod(val, last);
        }
    }

    private void displayForwardMethod(Link first){
        Link node = first;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private void displayBackwardMethod(Link last){
        Link node = last;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public void displayForward(){
        if(!isReversed){
            displayForwardMethod(first);
        }
        else{
            displayBackwardMethod(first);
        }
    }

    public void displayBackward(){
        if(!isReversed){
            displayBackwardMethod(last);
        }
        else{
            displayForwardMethod(last);
        }
    }

    public Link locateNode(int searchKey){
        Link node;

        if(!isReversed){
            node = first;
        }
        else{
            node = last;
        }

        while(node != null && node.value != searchKey){
            node = node.next;
        }
        return node; // null
    }

    public void insertAfter(int val, int searchKey){
        Link beforeNode = locateNode(searchKey);

        if(beforeNode == null){
            System.out.println("Nie znaleziono szukanego węzla o kluczu: " + searchKey);
            return;
        }

        Link newNode = new Link(val);

        if(!isReversed){
            newNode.prev = beforeNode;
            newNode.next = beforeNode.next;

            beforeNode.next = newNode;

            if(newNode.next != null){
                newNode.next.prev = newNode;
            }
        }
        else{
            newNode.next = beforeNode;
            newNode.prev = beforeNode.prev;

            beforeNode.prev = newNode;

            if(newNode.prev != null){
                newNode.prev.next = newNode;
            }
        }
    }

    public void deleteFirst(){
        if(first == null){ // empty ll
            System.out.println("Lista jest pusta!");
        }
        else if(last == first){ // only one node
            last = null;
            first = null;
        }
        else if(!isReversed){
            first = first.next;
            first.prev = null;
        }
        else{
            first = first.prev;
            first.next = null;
        }
    }

    public void deleteLast(){
        if(last == null){ // empty ll
            System.out.println("Lista jest pusta!");
        }
        else if(last == first){ // only one node
            last = null;
            first = null;
        }
        else if(!isReversed){
            last = last.prev;
            last.next = null;
        }
        else{
            last = last.next;
            last.prev = null;
        }
    }

    public void deleteKey(int searchKey){
        Link searchNode = locateNode(searchKey);

        if(searchNode == null){
            System.out.println("Nie znaleziono szukanego węzla o kluczu: " + searchKey);
        }
        else if(searchNode == first){
            deleteFirst();
        }
        else if(searchNode == last){
            deleteLast();
        }
        else{
            searchNode.prev.next = searchNode.next;
            searchNode.next.prev = searchNode.prev;
        }
    }

    //Hardcoded tests FTW :P
    public static void main(String [] args){
        LinkedList LL = new LinkedList();

        for(int i = 9; i >= 0; i--){
            //LL.insertFirst(i);
            LL.insertLast(i);
        }

        LL.displayForward();
        LL.displayBackward();

        for(int i = 0; i < 10; i++){
           //LL.insertLast(i + 100);
            LL.insertFirst(i + 100);
        }

        LL.displayForward();
        LL.displayBackward();

        System.out.println();

        for(int i = 0; i < 10; i++){
            LL.deleteFirst();
            LL.deleteLast();
            System.out.print("Forw: ");
            LL.displayForward();
            System.out.print("Back: ");
            LL.displayBackward();
        }


        for(int i = 9; i >= 0; i--){
            //LL.insertFirst(i);
            LL.insertLast(i);
        }

        LL.insertAfter(99, 5);
        LL.insertAfter(777, 8);

        System.out.print("Forw: ");
        LL.displayForward();
        System.out.print("Back: ");
        LL.displayBackward();

        LL.deleteKey(777);

        System.out.print("Forw: ");
        LL.displayForward();
        System.out.print("Back: ");
        LL.displayBackward();

        LL.deleteKey(99);

        System.out.print("Ford: ");
        LL.displayForward();
        System.out.print("Back: ");
        LL.displayBackward();
    }
}
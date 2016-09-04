package pl.kuczu.abstractDataType.linked;

//double linked list, without head and tail, is not cycle ll
public class linkedList {
    private link first;
    private link last;

    public linkedList() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(int val){
        link newNode = first;

        first = new link(val);

        first.next = newNode;

        if(last == null){
            last = first;
        }
        else{
            newNode.prev = first;
        }
    }

    public void insertLast(int val){
        link newNode = last;

        last = new link(val);

        last.prev = newNode;

        if(first == null){
            first = last;
        }
        else{
            newNode.next = last;
        }
    }

    public void displayForward(){
        link node = first;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        link node = last;

        while(node != null){
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public link locateNode(int searchKey){
        link node = first;

        while(node != null && node.value != searchKey){
            node = node.next;
        }
        return node; // null
    }

    public void insertAfter(int val, int searchKey){
        link newNode = new link(val);
        link beforeNode = locateNode(searchKey);

        if(beforeNode == null){
            System.out.println("Nie znaleziono szukanego węzla o kluczu: " + searchKey);
            return;
        }

        newNode.prev = beforeNode;
        newNode.next = beforeNode.next;

        beforeNode.next = newNode;

        if(newNode.next != null){
            newNode.next.prev = newNode;
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
        else{
            first = first.next;
            first.prev = null;
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
        else{
            last = last.prev;
            last.next = null;
        }
    }

    public void deleteKey(int searchKey){
        link searchNode = locateNode(searchKey);

        if(searchNode == null){
            System.out.println("Nie znaleziono szukanego węzla o kluczu: " + searchKey);
            return;
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
        linkedList LL = new linkedList();

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
            System.out.print("Ford: ");
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

        System.out.print("Ford: ");
        LL.displayForward();
        System.out.print("Back: ");
        LL.displayBackward();

        LL.deleteKey(777);

        System.out.print("Ford: ");
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
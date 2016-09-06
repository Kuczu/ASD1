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
        isReversed = !isReversed;

        Link nodeBuff = first;
        first = last;
        last = nodeBuff;
    }

    private Link insertFirstMethod(int val, Link first){
        Link newNode = first;

        first = new Link(val);

        first.next = newNode;

        if(last == null){
            last = first;
        }
        else{
            newNode.prev = first;
        }

        return first;
    }

    private Link insertLastMethod(int val, Link last){
        Link newNode = last;

        last = new Link(val);

        last.prev = newNode;

        if(first == null){
            first = last;
        }
        else{
            newNode.next = last;
        }

        return last;
    }

    public void insertFirst(int val){
        if(!isReversed){
            first = insertFirstMethod(val, first);
        }
        else{
            first = insertLastMethod(val, first);
        }
    }

    public void insertLast(int val){
        if(!isReversed){
            last = insertLastMethod(val, last);
        }
        else{
            last = insertFirstMethod(val, last);
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

    public Link[] findLongestNondecrasingList(){
        if(first == null){ // empty ll
            System.out.println("Lista jest pusta!");
            return new Link[]{null, null};
        }
        else if(last == first){ // only one node
            return new Link[]{first, last};
        }
        else{
            int nodesCount = 1;
            int prevNodesCount = 1;
            Link currentNode;

            if(!isReversed) {
                currentNode = first.next; //
            }
            else{
                currentNode = first.prev; //
            }

            Link firstNode = first;
            Link lastNode = first;

            Link nodes[] = new Link[2];

            while(currentNode != null){
                if(lastNode.value <= currentNode.value){
                    lastNode = currentNode;
                    nodesCount++;

                    if(!isReversed) {
                        currentNode = currentNode.next; //
                    }
                    else{
                        currentNode = currentNode.prev;
                    }
                }
                else{
                    if(nodesCount >= prevNodesCount){
                        nodes[0] = firstNode;
                        nodes[1] = lastNode;
                        prevNodesCount = nodesCount;
                    }

                    firstNode = currentNode;
                    lastNode = currentNode;
                    nodesCount = 1;

                    if(!isReversed) {
                        currentNode = currentNode.next; //
                    }
                    else{
                        currentNode = currentNode.prev;
                    }
                }
            }

            if(nodesCount >= prevNodesCount){
                nodes[0] = firstNode;
                nodes[1] = lastNode;
            }

            return nodes;
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

        for(int i = 0; i < 15; i++){
            //LL.insertLast(i + 100);
            LL.insertLast(i + 200);
        }

        /*for(int i = 2; i < 8; i++){
            LL.deleteKey(i);
        }*/

        LL.insertAfter(800, 0);
        LL.displayForward();

        Link nodes[] = LL.findLongestNondecrasingList();
        Link node = nodes[0];

        while(node != nodes[1].next){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();

        LL.reverseList();

        nodes = LL.findLongestNondecrasingList();
        node = nodes[0];

        while(node != nodes[1].prev){
            System.out.print(node.value + " ");
            node = node.prev;
        }
    }
}
package pl.kuczu.abstractDataType.linked;

//TODO tests
public class ListIterator {
    private Link current;
    //private Link previous // <- it is need if LL is one way
    private LinkedList list;

    public ListIterator(LinkedList list) {
        current = list.getFirst();
        this.list = list;
    }

    public void reset(){
        current = list.getFirst();
    }

    public boolean isEnd(){
        return current.next == null;
    }

    public void nextLink(){
        current = current.next;
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(int value){
        if(list.isEmpty()){ // first elem
            list.insertFirst(value);
        }
        else{
            list.insertAfter(value, current.value);
        }
        nextLink();
    }

    public void inserBefore(int value){
        if(list.isEmpty() || current.prev == null){ // first elem
            list.insertFirst(value);
        }
        else{
            list.insertAfter(value, current.prev.value);
        }
    }

    public int deleteCurrent(){
        if(current != null){
            int returnValue = current.value;

            list.deleteKey(returnValue);

            return returnValue;
        }

        return -1; // exception need
    }
}
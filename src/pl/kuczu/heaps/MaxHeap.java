package pl.kuczu.heaps;

public class MaxHeap extends Heap{
    public MaxHeap(int size){
        heapArray = new int[size];
        emptyIdx = 0;
    }

    //log2(n)
    public void upheap(int idxToUp){
        int parent = (idxToUp - 1) / 2;
        int valToUp = heapArray[idxToUp];

        while(idxToUp > 0 &&  heapArray[parent] < valToUp){
            heapArray[idxToUp] = heapArray[parent]; // parent goes down
            idxToUp = parent; // current idx became parent
            parent = (parent - 1) / 2; // parent current idx
        }

        heapArray[idxToUp] = valToUp;
    }

    //log2(n)
    public void downheap(int idxToDown){
        int child;
        int valToDown = heapArray[idxToDown];

        while(idxToDown < emptyIdx / 2){
            child = 2 * idxToDown + 1; // left child

            if(child < emptyIdx - 1 && heapArray[child] < heapArray[child + 1]){ // check if to choose right child or stay at left
                child++;
            }

            if(valToDown >= heapArray[child]){ // heap is repaired
                break;
            }

            heapArray[idxToDown] = heapArray[child];
            idxToDown = child;
        }

        heapArray[idxToDown] = valToDown;
    }

    //O(1)
    public int getMax(){
        return heapArray[0];
    }

    //log2(n)
    public int deleteMax(){ // need condition for checking if the heap is empty
        int max = heapArray[0];

        emptyIdx--;
        heapArray[0] = heapArray[emptyIdx];

        downheap(0);

        return max;
    }

    //n log2(n)
    public void heapSort(){
        for(int k = (emptyIdx - 1) / 2; k >= 0; k--){
            downheap(k);
        } // heapArray is partly sorted ascending

        while(emptyIdx > 0){
            swap(0, emptyIdx - 1);
            emptyIdx--;
            downheap(0);
        } //heapArray is sorted descending
    }
}

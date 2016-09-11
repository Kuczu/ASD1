package pl.kuczu.heaps;

public abstract class Heap {
    protected int heapArray[];
    protected int emptyIdx;

    public boolean insert(int val){
        if(emptyIdx == heapArray.length){
            return false;
        }

        heapArray[emptyIdx] = val;

        upheap(emptyIdx);
        emptyIdx++;

        return true;
    }

    public abstract void upheap(int idxToUp);

    public abstract void downheap(int idxToDown);

    protected void swap(int idx1, int idx2){
        int tempVal = heapArray[idx1];
        heapArray[idx1] = heapArray[idx2];
        heapArray[idx2] = tempVal;
    }
}

package pl.kuczu.heaps;

public class HeapMerge{
    private int sequenceArray[][]; // [amountOfSequences][sequence]
    private int sequenceLength[];
    private int sequenceNumber;

    public HeapMerge(int[][] sequenceArray) {
        this.sequenceArray = sequenceArray;
        this.sequenceLength = new int[sequenceArray.length];
        this.sequenceNumber = sequenceLength.length;

        for(int i = 0; i < sequenceNumber; i++){
            sequenceLength[i] = sequenceArray[i].length;
        }
    }

    public int[] mergeSequences(){
        MinHeap heap = new MinHeap(sequenceNumber);

        //TODO

        return new int[]{-1};
    }
}

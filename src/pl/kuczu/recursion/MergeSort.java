package pl.kuczu.recursion;

public class MergeSort {
    private int numbOfInversion;
    private long table[];

    public MergeSort(long[] table) {
        this.table = table;
        numbOfInversion = 0;
    }

    public int getNumbOfInversion() {
        return numbOfInversion;
    }

    public void mergeSort(int left, int right){
        int center;

        if(left < right){
            center = (left + right) / 2;
            mergeSort(left, center);
            mergeSort(center + 1, right);
            merge(left, right, center);
        }
    }

    private void merge(int left, int right, int center){
        long helpTable[] = new long[right - left + 1];

        for(int i = left; i <= right; i++){
            helpTable[i] = table[i];
        }

        int leftTableIdx = left;
        int rightTableIdx = center + 1;
        int firstFreeIdx = left;

        while(leftTableIdx <= center && rightTableIdx <= right){
            if(helpTable[leftTableIdx] <= helpTable[rightTableIdx]){
                table[firstFreeIdx++] = helpTable[leftTableIdx++];
            }
            else{
                table[firstFreeIdx++] = helpTable[rightTableIdx++];
                numbOfInversion = numbOfInversion + center - leftTableIdx + 1;
            }
        }

        while(leftTableIdx <= center){
            table[firstFreeIdx++] = helpTable[leftTableIdx++];
        }

        while(rightTableIdx <= right){
            table[firstFreeIdx++] = helpTable[rightTableIdx++];
        }
    }
}

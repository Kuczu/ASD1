package pl.kuczu.recursion;

public class MergeSort {
    private long helpTable[];
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
        int i;
        int j;
        int q;

        for(i = left; i <= right; i++){
            helpTable[i] = table[i];
        }

        i = left;
        j = center + 1;
        q = left;

        while(i <= center && j <= right){
            if(helpTable[i] <= helpTable[j]){
                table[q++] = helpTable[j++];
            }
            else{
                table[q++] = helpTable[j++];
                numbOfInversion = numbOfInversion + center - i + 1;
            }
        }

        while(i <= center){
            table[q++] = helpTable[i++];
        }
    }
}

package pl.kuczu.sort;

public class QuickSort {
    private int Array[];

    public QuickSort(int[] array) {
        this.Array = array;
    }

    public void quickSortRecursion(int left, int right){
        if(left >= right){
            return;
        }

        int q = partition(left, right);
        //int q = partitionLomuto(left, right);
        quickSortRecursion(left, q - 1);
        quickSortRecursion(q + 1, right);
    }

    private int partition(int left, int right){ // Hoare
        int leftIdx = left - 1;
        int rightIdx = right;
        int dividingValue = Array[right];

        while(true){
            while(Array[++leftIdx] < dividingValue);

            while(rightIdx > left && Array[--rightIdx] > dividingValue);

            if(leftIdx >= rightIdx){
                break;
            }
            else{
                swap(leftIdx, rightIdx);
            }
        }

        swap(leftIdx, right);
        return leftIdx;
    }

    private int partitionLomuto(int left, int right){
        int i = left - 1;
        int dividingValue = Array[right];

        for(int j = left; j < right; j++){
            if(Array[j] <= dividingValue){
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, right);

        return ++i;
    }

    private void swap(int i, int j){
        int temp = Array[i];
        Array[i] = Array[j];
        Array[j] = temp;
    }
}

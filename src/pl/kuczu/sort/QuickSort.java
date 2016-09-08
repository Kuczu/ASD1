package pl.kuczu.sort;

public class QuickSort {
    private int array[];

    public QuickSort(int[] array) {
        this.array = array;
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

    private int partition(int left, int right){
        int i = left - 1;
        int j = right;
        int x = array[right];

        while(true){
            while(j > left && array[--j] > x);

            if(i >= j){
                break;
            }
            else{
                swap(i, j);
            }
        }

        swap(i, right);
        return i;
    }

    private int partitionLomuto(int left, int right){
        int i = left - 1;
        int x = array[right];

        for(int j = left; j < right; j++) {
            if(array[j] <= x) {
                i++;
                swap(i, j);
            }
        }
            swap(i + 1, right);

            return ++i;
    }

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = array[temp];
    }
}

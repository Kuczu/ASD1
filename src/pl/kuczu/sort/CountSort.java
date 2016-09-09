package pl.kuczu.sort;

public class CountSort {
    private int array[];
    private int maxValue;
    private int count[]; // filled by 0

    public CountSort(int[] array, int maxValue) {
        this.array = array;
        this.maxValue = maxValue;
        this.count = new int[maxValue];
    }

    public int[] sort(){ // return sortedArray, can be void then copy sortedArray to Array
        int sortedArray[] = new int[array.length];

        for(int i = 0; i < array.length; i++){
            count[array[i]]++;
        }

        for(int i = 1; i < maxValue; i++){
            count[i] = count[i - 1] + count[i];
        }

        for(int i = array.length - 1; i > -1; i--){
            count[ array[ i ] ]--;
            sortedArray[ count[ array[ i ] ] ] = array[i];
        }

        return sortedArray;
    }
}

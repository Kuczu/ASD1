package pl.kuczu.arrays;

import pl.kuczu.arrays.Array;

public class SimpleArraySorting extends Array {
    public SimpleArraySorting(int size){
        super(size);
    }

    void swap(int a, int b){
        long temp = Array[a];
        Array[a] = Array[b];
        Array[b] = temp;
    }

    void bubbleSort(){
        for(int k = Size - 1; k >= 1; k--){
            for(int j = 0; j < k; j++){
                if(Array[j] > Array[j + 1]){
                    swap(j, j + 1);
                }
            }
        }
    }

    void slectionSort(){
        int min;

        for(int k = 0; k < Size - 1; k++){
            min = k;

            for(int j = k + 1; j < Size; j++){
                if(Array[j] < Array[min]){
                    min = j;
                }
            }

            swap(k, min);
        }
    }

    void insertionSort(){
        int j;
        long v;

        for(int k = 1; k < Size; k++){
            j = k - 1;
            v = Array[k];

            while(j >= 0 && v < Array[j]){
                Array[j + 1] = Array[j];
                j--;
            }

            Array[j + 1] = v;
        }
    }
}

package pl.kuczu.recursion;

import java.util.Random;

public class MergeSort {
    private int numbOfInversion;
    private int array[];
    private int helpTable[];

    public MergeSort(int[] array) {
        this.array = array;
        helpTable = new int[array.length];
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
        for(int i = left; i <= right; i++){
            helpTable[i] = array[i];
        }

        int leftTableIdx = left;
        int rightTableIdx = center + 1;
        int firstFreeIdx = left;

        while(leftTableIdx <= center && rightTableIdx <= right){
            if(helpTable[leftTableIdx] <= helpTable[rightTableIdx]){
                array[firstFreeIdx++] = helpTable[leftTableIdx++];
            }
            else{
                array[firstFreeIdx++] = helpTable[rightTableIdx++];
                numbOfInversion = numbOfInversion + center - leftTableIdx + 1;
            }
        }

        while(leftTableIdx <= center){
            array[firstFreeIdx++] = helpTable[leftTableIdx++];
        }

        while(rightTableIdx <= right){
            array[firstFreeIdx++] = helpTable[rightTableIdx++];
        }
    }

    public void printArray(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void fillArrayRandomNumbers(int array[]){
        Random rand = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(Integer.SIZE - 1);
        }
    }

    public static void main(String args[]){
        int arr[] = new int[50];
        fillArrayRandomNumbers(arr);

        MergeSort ms = new MergeSort(arr);

        ms.printArray();
        ms.mergeSort(0, arr.length - 1);
        ms.printArray();
    }
}

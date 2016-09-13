package pl.kuczu.sort;

import java.util.Random;

public class QuickSortNonrecursion {
    private int array[];

    public QuickSortNonrecursion(int[] array){
        this.array = array;
    }

    public void quickSort(){
        int left = 0;
        int right = array.length - 1;
        int currTemp;
        int curr = right;

        int i = 0;
        while (true) {
            i--;

            while(left < curr){
                currTemp = partition(left, curr);

                array[curr] = -array[curr];
                //array[currTemp] = -array[currTemp];
                curr = currTemp - 1;

                i++;
            }

            if (i < 0){
                break;
            }

            left++;

            curr = findNextCurr(left);

            array[curr] = -array[curr];
        }
    }

    private int findNextCurr(int left){
        for (int i = left; i < array.length; i++){
            if (array[i] < 0){
                return i;
            }
        }
        return array.length - 1;
    }

    private int partition(int left, int right){
        int pivot = array[(left + right) / 2];

        while(left <= right){
            while (array[right] > pivot){
                right--;
            }

            while (array[left] < pivot){
                left++;
            }

            if (left <= right) {
                if(right != left){
                    swap(right, left);
                }

                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int i, int j){
        int buff = array[i];
        array[i] = array[j];
        array[j] = buff;
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
        int arr[] = new int[10];
        fillArrayRandomNumbers(arr);

        QuickSortNonrecursion qs = new QuickSortNonrecursion(arr);

        qs.printArray();
        qs.quickSort();
        qs.printArray();
    }


}


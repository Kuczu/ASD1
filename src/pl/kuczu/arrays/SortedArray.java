package pl.kuczu.arrays;

import java.util.Random;
import java.util.Scanner;

public class SortedArray {
    private int Size;
    private long Array[];
    private int CurrPosition;

    public int getSize() {
        return Size;
    }

    public long getValue(int position) {
        if(position > CurrPosition){
            System.out.println("Pozycja poza zakresem!");
            return 0;
        }

        return Array[position];
    }

    public SortedArray(int size){
        Size = size;
        Array = new long[size];

        fillArrayRandomNumbers();
    }

    public void fillArrayRandomNumbers(){
        Random rand = new Random();

        Array[0] = rand.nextInt(10);

        for(int i = 1; i < Size; i++){
            Array[i] = Array[i - 1] + rand.nextInt(10);
        }

        CurrPosition = Size - 1;
    }

    public int find_count(long val){
        int start;
        int end = CurrPosition;
        int middle;
        boolean isExistVal = false;

        //first left position
        start = 0;
        middle = (start + end) / 2;
        int idxExistValLeft = 0;

        while(start <= end){
            if(val < Array[middle]){
                end = middle - 1;
                middle = (start + end) / 2;
            }
            else if(val > Array[middle]){
                start = middle + 1;
                middle = (start + end) / 2;
            }
            else{ // ==
                isExistVal = true;
                end = middle - 1;
                idxExistValLeft = middle;
                middle = (start + end) / 2;
            }
        }

        //last right position
        if(isExistVal){
            int idxExistValRight = 0;
            start = idxExistValLeft;
            end = CurrPosition;
            middle = (start + end) / 2;

            while(start <= end){
                if(val < Array[middle]){
                    end = middle - 1;
                    middle = (start + end) / 2;
                }
                else if(val > Array[middle]){
                    start = middle + 1;
                    middle = (start + end) / 2;
                }
                else{ // ==
                    start = middle + 1;
                    idxExistValRight = middle;
                    middle = (start + end) / 2;
                }
            }

            return idxExistValRight - idxExistValLeft + 1;
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SortedArray SA = new SortedArray(20);

        for(int i = 0; i < SA.getSize(); i++){
            System.out.print(SA.getValue(i) + " ");
        }
        System.out.println();

        while(true){
            long x = input.nextLong();

            System.out.print(SA.find_count(x) + " ");
        }
    }
}
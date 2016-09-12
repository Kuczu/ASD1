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

        fillArrayRandomSortedNumbers();
    }

    public void fillArrayRandomSortedNumbers(){
        Random rand = new Random();

        Array[0] = rand.nextInt(10);

        for(int i = 1; i < Size; i++){
            Array[i] = Array[i - 1] + rand.nextInt(10);
        }

        CurrPosition = Size - 1;
    }

    // Contain redundant algorithm LE and GE - depends on exercise conditions
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

    public int find_LE(long val){
        int start = 0;
        int end = CurrPosition;
        int middle = (start + end) / 2;
        int idxExistValRight = -1;

        //last right position
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

        return idxExistValRight + 1;
    }

    public int find_GE(long val){
        int start = 0;
        int end = CurrPosition;
        int middle = (start + end) / 2;
        int idxExistValLeft = -1;

        //last left position
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
                end = middle - 1;
                idxExistValLeft = middle;
                middle = (start + end) / 2;
            }
        }

        if(idxExistValLeft < 0){
            return 0;
        }

        return Size - idxExistValLeft;
    }

    public void delDup(){
        if (Array.length < 2){
            return;
        }

        int j = 0;
        int i = 1;

        while(i < Size){
            if(Array[j] == Array[i]){
                i++;
            }else{
                j++;
                Array[j] = Array[i];
                i++;
            }
        }

        for(i = j + 1; i < Size; i++){
            Array[i] = 0;
        }
    }

    public int bin_search(long val){
        return find_LE(val) - 1;
    }

    public int interpol_search(long val){
        int low = 0;
        int upp = Size - 1;
        int currentIdx;

        while((val >= Array[low]) && (val <= Array[upp])){
            currentIdx = low + ((int)val - (int)Array[low]) * (upp - low) / ((int)Array[upp] - (int)Array[low]);

            if(Array[currentIdx] == val){
                return currentIdx;
            }
            else if(val < Array[currentIdx]){
                upp = currentIdx - 1;
            }
            else{
                low = currentIdx + 1;
            }
        }

        return -1;
    }

    public void printArray(){
        for(int i = 0; i < Size; i++){
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SortedArray SA = new SortedArray(20);

        SA.printArray();

        long x = input.nextLong();
        while(x != -1){
            System.out.println("Count: " + SA.find_count(x));
            System.out.println("LE: " + SA.find_LE(x));
            System.out.println("GE: " + SA.find_GE(x));
            System.out.println("Interpol Search: " + SA.interpol_search(x));

            x = input.nextLong();
        }

        System.out.println();
        SA.printArray();
        SA.delDup();
        SA.printArray();
    }
}
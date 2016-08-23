package pl.kuczu.arrays;

import java.util.Random;

public class Array {
    private int Size;
    private long Array[];
    private int CurrPosition;

    public Array(int size){
        Size = size;
        Array = new long[size];

        fillArrayRandomNumbers();
    }

    public void fillArrayRandomNumbers(){
        Random rand = new Random();

        for(int i = 0; i < Size; i++){
            Array[i] = rand.nextLong();
        }

        CurrPosition = Size - 1;
    }

    public void insert(long value, int position){
        if(position >= Size && position > position + 1){
            System.out.println("Pozycja poza zakresem!");
            return;
        }

        Array[position] = value;
    }

    public void delete(int position){
        if(position >= Size && position > position + 1){
            System.out.println("Pozycja poza zakresem!");
            return;
        }

        //Override value to 0
        //Array[position] = 0;

        //Copy everything by 1 position from right to position
        for(; position <= CurrPosition; position++){
            Array[position] = Array[position + 1];
        }

        CurrPosition--;
    }

    public boolean isOrder(){
        int currPosition = 0;

        long temp = Array[currPosition];

        for(currPosition++; currPosition <= CurrPosition; currPosition++){
            if(temp <= Array[currPosition]){
                temp = Array[currPosition];
            }
            else{
                return false;
            }
        }

        return true;
    }

    public void del_Dupl(){
        for(int currPosition = 0; currPosition <= CurrPosition; currPosition++){
            long temp = Array[currPosition];

            for(int current = currPosition + 1; current <= CurrPosition; current++){
                if(temp == Array[current]){
                    Array[current] = Array[CurrPosition];
                    CurrPosition--;
                }
            }
        }
    }
}

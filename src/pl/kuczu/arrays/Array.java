package pl.kuczu.arrays;

import java.util.Random;

/**
 * W klasie zaimplementowane zostały podstawowe operacje na tablicy
 */
public class Array {
    protected int size;
    protected long array[];
    protected int currPosition;

    /**
     * Konstruktor tablicy, automatycznie wypełnia ją losowymi liczbami.
     * @see Array#fillArrayRandomNumbers()
     * @param size wielkość tablicy - alokowanego miejsca
     */
    public Array(int size){
        this.size = size;
        array = new long[size];

        fillArrayRandomNumbers();
    }

    /**
     * Wypełnia całą tablicę losowymi liczbami (nadpisuje istniejące)
     */
    public void fillArrayRandomNumbers(){
        Random rand = new Random();

        for(int i = 0; i < size; i++){
            array[i] = rand.nextLong();
        }

        currPosition = size - 1;
    }

    /**
     * Na daną pozycję zapisuje zapisuje podaną wartość, złożoność czasowa O(1)
     * @param value wartośc do zapisania w tablicy
     * @param position pozaycja może być taka do jakiej tablica jest aktualnie wypełniona lub pozycję o jeden dalej
     */
    public void insert(long value, int position){
        if(position >= size && currPosition + 1 < position){
            System.out.println("Pozycja poza zakresem!");
            return;
        }

        array[position] = value;

        if(currPosition < position){
            currPosition++;
        }
    }

    /**
     * Funkcja usuwa z podanej pozycji liczbę, pesymistyczna złożoność czasowa O(n)
     * @param position pozycja z jakiej liczba ma być usunięta
     */
    public void delete(int position){
        if(position >= size && currPosition < position){
            System.out.println("Pozycja poza zakresem!");
            return;
        }

        //Override value to 0
        //array[position] = 0;

        //Copy everything by 1 position from right to position
        for(; position <= currPosition; position++){
            array[position] = array[position + 1];
        }

        currPosition--;
    }

    /**
     * Funkcja sprawdza czy liczby w całej tablicy są ułożone w porządku niemalejącym, pesymistyczna złożoność czasowa O(n)
     * @return true jeśli tablica jest niemalejąca
     */
    public boolean isOrder(){
        int currPosition = 0;

        long temp = array[currPosition];

        for(currPosition++; currPosition <= this.currPosition; currPosition++){
            if(temp <= array[currPosition]){
                temp = array[currPosition];
            }
            else{
                return false;
            }
        }

        return true;
    }

    /**
     * Funkcja usuwa duplikaty z tablicy, złożoność czasowa O(n^2)
     * Funkcja działa tak, że dla każdego elementu z tablicy (pierwsza pętla) sprawdza kolejne liczby aż do końca tablicy (druga pętla),
     * po napodkaniu duplikatu przepisuje ostatni element (jeśli nie jest duplikatem) na miejsce duplikatu,
     * natomiast jeśli ostatni element jest także duplikatem, tablica jest pomniejszana tak długo aż nie napodka na liczbę nie będącą duplikatem
     */
    public void del_Dupl(){
        for(int currPosition = 0; currPosition <= this.currPosition; currPosition++){
            long temp = array[currPosition];

            for(int current = currPosition + 1; current <= this.currPosition; current++){
                if(temp == array[current]){
                    while(temp == array[this.currPosition] && this.currPosition > currPosition){
                        this.currPosition--;
                    }

                    if(this.currPosition >= current){
                        array[current] = array[this.currPosition];
                        this.currPosition--;
                    }
                }
            }
        }
    }
}

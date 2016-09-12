package pl.kuczu.arrays;

/**
 * W klasie zaimplementowane zostały trzy algorytmy sortujące z rodziny "prostych algorytmów sortujących",
 * wszystkie mają złożoność czasową O(n^2) i pamięciową O(1), lecz najowlniejszym z nich jest {@link SimpleArraySorting#bubbleSort},
 * wydajniejszy z nich jest {@link SimpleArraySorting#slectionSort}, najszybszy natomiast jest {@link SimpleArraySorting#insertionSort()} który może być nawet 2 razy szybszy od BubbleSort
 */
public class SimpleArraySorting extends Array {
    public SimpleArraySorting(int size){
        super(size);
    }

    private void swap(int a, int b){
        long temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Algorytm ma złożoność czasową O(n^2), jest stabilny
     * Funkcja porównuje dwa sąsiadujące obok siebie elementy - druga pętla, po porównaniu na końcu tablicy znajduje się największy element - pierwsza pętla zmienjsza zakres o 1
     */
    public void bubbleSort(){
        for(int k = size - 1; k >= 1; k--){
            for(int j = 0; j < k; j++){
                if(array[j] > array[j + 1]){
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * Algorytm ma złożoność czasową O(n^2), NIE jest stabilny
     * Funkcja przeszukuje liniowo tablice w poszukiwaniu najmniejszego elementu, następnie element ten daje na początek zakresu który wyznacza pierwsza pętla
     */
    public void slectionSort(){
        int min;

        for(int k = 0; k < size - 1; k++){
            min = k;

            for(int j = k + 1; j < size; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }

            swap(k, min);
        }
    }

    /**
     * Algorytm ma złożoność czasową O(n^2), jest stabilny,
     * optymalny dla ciągów prawie posortowanych, dlatego może być stosowany jako końcowy etap bardziej złożonych algorytmów sortowania
     * Pierwsza pętla funkcji przechodzi od początku tablicy do jej końca,
     * natomiast w zagnieżdżonej pętli od końca zakresu wyznaczonego przez pierwszą pętlę, sprawdzany jest warunek czy kolejna (poprzednia) wartość jest większa od porównywanej,
     * jeśli jest to wartość ta jest przesuwana (przepisywana) do komórki o kolejnym indeksie, po skończeniu pętli wartość porównywana jest przepisywana na wyznaczone miejsce
     */
    public void insertionSort(){
        int idx;
        long tempValue;

        for(int k = 1; k < size; k++){
            idx = k - 1;
            tempValue = array[k];

            while(idx >= 0 && tempValue < array[idx]){
                array[idx + 1] = array[idx];
                idx--;
            }

            array[idx + 1] = tempValue;
        }
    }
}

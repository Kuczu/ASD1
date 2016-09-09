package pl.kuczu.linearSearch;

public class MedianaMedian {
    public int median(int array[], int k){
        if(array.length <= 50){
            insertionSort(array, 0, array.length - 1);
            return array[k - 1];
        }

        int i;
        for(i = 4; i < array.length; i += 5){
            insertionSort(array, i - 4, i);
        }

        if(i - 5 < array.length){
            insertionSort(array, i + 1, array.length - 1);
        }

        int x = ((array.length % 5) < 3 ? 0 : 1);
        int buffTable[] = new int[array.length / 5  + x];

        for(i = 0; i < array.length / 5 + x; i++){
            buffTable[i] = array[i * 5 + 2 ];
        }

        int medianR = median(buffTable, buffTable.length / 2);

        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;

        for(i = 0; i < array.length; i++){
            if(array[i] < medianR){
                counter1++;
            }
            else if(array[i] == medianR){
                counter2++;
            }
            else{
                counter3++;
            }

        }

        if(k <= counter1){
            buffTable = new int[counter1];
            int j = 0;

            for(i = 0; i < array.length; i++){
                if(array[i] < medianR){
                    buffTable[j++] = array[i];
                }
            }
            medianR = median(buffTable, k);
        }
        else if(k <= counter1 + counter2){
            return medianR;
        }
        else{
            buffTable = new int[counter3];
            int j = 0;

            for(i = 0; i < array.length; i++){
                if(array[i] > medianR){
                    buffTable[j++] = array[i];
                }
            }
            medianR = median(buffTable, k - counter1 - counter2);
        }

        return medianR;
    }

    private void insertionSort(int array[], int begin, int end) {
        int j;
        int buff;
        for(int g = begin + 1; g <= end; g++){
            j = g - 1;
            buff = array[g];

            while(j >= 0 && buff < array[j]){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = buff;
        }
    }
}

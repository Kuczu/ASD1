package pl.kuczu.linearSearch;

public class Hoare{ // extends for partition method
    public int search(int array[], int kth){
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;

        int divider = array[0];

        for(int i = 0; i < array.length; i++){
            int compare = array[i];

            if(compare < divider){
                counter1++;
            }
            else if(compare == divider){
                counter2++;
            }
            else{
                counter3++;
            }
        }

        if(kth <= counter1){
            int helpTable[] = new int[counter1];
            int j = 0;

            for(int i = 0; i < array.length; i++){
                if(array[i] < divider){
                    helpTable[j++] = array[i];
                }
            }

            return search(helpTable, kth);
        }
        else if(kth <= (counter1 + counter2)){
            return divider;
        }
        else{
            int helpTable[] = new int[counter3];
            int j = 0;

            for(int i = 0; i < array.length; i++){
                if(array[i] > divider){
                    helpTable[j++] = array[i];
                }
            }

            return search(helpTable, kth - (counter1 + counter2));
        }
    }

    public static void main(String args[]){
        Hoare hoare = new Hoare();

        int arr[] = {8, 12, 3, 7, 15, 1, 18, 9, 8, 4, 17, 14, 11};

        for(int i = 1; i <= arr.length; i++){
            System.out.print(hoare.search(arr, i) + " ");
        }

    }
}

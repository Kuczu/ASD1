package pl.kuczu.sort;

public class QuickSortNonrecursion {
    private int array[];

    public QuickSortNonrecursion(int[] array) {
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

            while (left < curr) {
                currTemp = partition(left, curr);

                array[curr] = -array[curr];
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

    private int partition(int left, int right) {
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

    public void swap(int i, int j){
        int buff = array[i];
        array[i] = array[j];
        array[j] = buff;
    }


}


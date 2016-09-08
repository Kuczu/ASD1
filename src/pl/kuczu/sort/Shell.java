package pl.kuczu.sort;

public class Shell {
    private int array[];

    public Shell(int[] array) {
        this.array = array;
    }

    public void shellSort(){
        int gap = 1;
        int j;
        int gaps;
        int arrLength = array.length - 1;
        int div = arrLength/3;

        while(gap <= div){
            gap = gap * 3 + 1;
        }

        while(gap > 0){
            for(gaps = gap; gaps < arrLength; gaps++){
                int tempValue = array[gaps];
                j = gaps;

                while(j > gap - 1 && array[j - gap] >= tempValue){
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = tempValue;
            }

            gap = (gap - 1) / 3;
        }
    }
}

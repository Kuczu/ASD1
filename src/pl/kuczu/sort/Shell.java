package pl.kuczu.sort;

public class Shell {
    private int Array[];

    public Shell(int[] array) {
        this.Array = array;
    }

    public void shellSort(){
        int gap = 1;
        int j;
        int gaps;
        int arrLength = Array.length - 1;
        int div = arrLength / 3;

        while(gap <= div){
            gap = gap * 3 + 1;
        }

        while(gap > 0){
            for(gaps = gap; gaps < arrLength; gaps++){
                int tempValue = Array[gaps];
                j = gaps;

                while(j > gap - 1 && Array[j - gap] >= tempValue){
                    Array[j] = Array[j - gap];
                    j = j - gap;
                }
                Array[j] = tempValue;
            }

            gap = (gap - 1) / 3;
        }
    }
}

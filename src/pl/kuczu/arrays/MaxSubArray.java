package pl.kuczu.arrays;

import java.util.Scanner;

public class MaxSubArray{
    private short Row;
    private short Column;
    private int Start;
    private int End;

    private int MaxSubsequence(int array[]){ // Kadame
        int sum = 0;
        int maxSum = 0;
        int localStart = 0;

        for(int i = 0; i < Column; i++){
            sum = sum + array[i];

            if(sum <= 0){ // if sum is 0 or negative, localStart move by 1 to the right
                sum = 0;
                localStart = i + 1;
            }
            else if(sum > maxSum){
                maxSum = sum;
                Start = localStart;
                End = i;
            }
        }

        return maxSum;
    }

    private void MaxArray(short array[][]){
        int left;
        int right;
        int leftAns = 0;
        int rightAns = 0;
        int topAns = 0;
        int bottomAns = 0;
        int sum;
        int maxSum = 0;
        int dimMaxArray;
        int dimMaxArrayNew;

        for(right = 0; right < Row; right++){ // goes through left to right
            int helpArray[] = new int[Column];

            for(left = right; left < Row; left++){ // from given left row goes to right row

                for(int i = 0; i < Column; i++){
                    // depends on exercise conditions
                    if(array[left][i] > 0){
                        helpArray[i] = helpArray[i] + 3 * array[left][i];
                    }
                    else{
                        helpArray[i] = helpArray[i] + 2 * array[left][i];
                    }
                }

                sum = MaxSubsequence(helpArray);

                dimMaxArray = ((leftAns - rightAns) + 1) * ((bottomAns - topAns) + 1);
                dimMaxArrayNew = ((left - right) + 1) * ((End - Start) + 1);

                if(sum > maxSum){
                    maxSum = sum;
                    leftAns = left;
                    rightAns = right;
                    topAns = Start;
                    bottomAns = End;
                }
                else if(sum == maxSum &&
                        ((leftAns - rightAns) >= (left - right) && (bottomAns - topAns) > (End - Start)) ||
                        ((leftAns - rightAns) > (left - right) && (bottomAns - topAns) >= (End - Start)) ||
                        (dimMaxArray < dimMaxArrayNew)){
                    maxSum = sum;
                    leftAns = left;
                    rightAns = right;
                    topAns = Start;
                    bottomAns = End;
                }
            }
        }

        System.out.println("max_sum=" + maxSum);
        System.out.println("[" + rightAns + ".." + leftAns + ", " + topAns + ".." + bottomAns + "]");
    }

    //imitation of public static void main(String [] args) ...
    public void main(){
        /*        */
        System.out.println(this.getClass().getSimpleName());
        /*        */

        Scanner input = new Scanner(System.in);

        short numbOfSets;
        short helper = 10; // helps faster find out edge cases, depends on exercise conditions

        numbOfSets = input.nextShort();

        for(int i = 0; i < numbOfSets; i++){
            Row = input.nextShort();
            Column = input.nextShort();

            short array[][] = new short[Row][Column];

            for(int j = 0; j < Row; j++){
                for(int k = 0; k < Column; k++){
                    array[j][k] = input.nextShort();

                    if(array[j][k] > 0){
                        helper = 1;
                    }
                    else if(array[j][k] == 0 && (helper != 1 && helper != -1)){
                        helper = 0;
                    }
                    else if(array[j][k] < 0 && helper != 1){
                        helper = -1;
                    }
                }
            }

            if(helper < 0){
                System.out.println("0");
            }
            else if(helper == 0){
                System.out.println("max_sum=0");
                System.out.println("[0..0, 0..0]");
            }
            else{
                MaxArray(array);
            }

            helper = 10;
        }
    }
}

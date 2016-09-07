package pl.kuczu.recursion;

import java.util.Scanner;

public class Backpack {
    private int data[];
    private int answer[];
    private int count;
    private Scanner input = new Scanner(System.in);

    public Backpack(int arrLenght) {
        this.data = new int[arrLenght];
        this.answer = new int[data.length];
        count = 0;

        getData();
    }

    public int[] getAnswer() {
        return answer;
    }

    public int getCount() {
        return count;
    }

    public boolean solveBackpackProblem(int itemNumber, int capacity){
        if(itemNumber == data.length){
            return false;
        }

        int sum = capacity - data[itemNumber];

        if(sum == 0 || sum > 0 && solveBackpackProblem(itemNumber + 1, sum)){
            answer[count] = data[itemNumber];
            //end = true;
            count++;
            return true;
        }
        else{
            return solveBackpackProblem(itemNumber + 1, capacity);
        }
    }

    public void getData(){
        for(int i = 0; i < data.length; i++){
            data[i] = input.nextInt();
        }
    }

    public static void main(String args[]){
        Scanner inp = new Scanner(System.in);
        int capacity = inp.nextInt();

        Backpack bp = new Backpack(inp.nextInt());

        if(bp.solveBackpackProblem(0, capacity)){
            System.out.print(capacity + " =");
            int answer[] = bp.getAnswer();

            for(int numb = bp.getCount() - 1; numb >= 0; numb--){
                System.out.print(" " + answer[numb]);
            }

            System.out.println();
        }
        else{
            System.out.println("BRAK");
        }
    }

}

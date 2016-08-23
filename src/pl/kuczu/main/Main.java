package pl.kuczu.main;

import pl.kuczu.arrays.MaxSubArray;

import java.util.Scanner;

public class Main {
    //private static String chapters[] = new String[16];

    private static void printMenu(){
        System.out.println("1. Tablice");
        System.out.println("\tb. Algorytm wyznaczania \"Maksymalnej podtablicy\"");
        System.out.print("\tc. Wybrane algorytmy na tablicach:\n"
                + "\t\tI. void insert(long val, int p); // wstawia element x na pozycje p\n"
                + "\t\tII. void delete(int p); // usuwa element z pozycji p\n"
                + "\t\tIII. boolean isOrder(); // sprawdza porzadke niemalejacy\n"
                + "\t\tIV. void del_Dup(); // usuwa duplikaty złożoność O(n2)\n");
        System.out.print("\td. Wybrane algorytmy na tablicach uporzadkowanych\n"
                + "\t\tI. int find_count(long val);\n"
                + "\t\tII. int find_LE(long val);\n"
                + "\t\tIII. int find_LE(long val);\n"
                + "\t\tIV. void delDupl();\n"
                + "\t\tV. int bin_search(long searchKey);\n"
                + "\t\tVI. int interpol_search(int x);\n");
    }

   /* private static void getInput(){
        Scanner input = new Scanner(System.in);

        String choose = input.next();
    }*/

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        printMenu();

        String choose = input.next();

        if(choose.equals("1")){
            choose = input.next();

            if(choose.equals("b")){
                MaxSubArray MSA = new MaxSubArray();
                MSA.main();
            }
            else if(choose.equals("c")){

            }
            else if(choose.equals("d")){

            }
            else{
                System.out.println("Podałeś zła wartość");
            }
        }
    }
}

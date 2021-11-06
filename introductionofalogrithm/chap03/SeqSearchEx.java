package chap03;

import java.sql.SQLOutput;

public class SeqSearchEx {

    static int seqSearchSen(int[] a, int n, int key) {

        int index = -1;

        System.out.print("  |");
        for(int i = 0; i < n; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n- +");
        for(int i = 0; i < n; i++) {
            System.out.print(" -");
        }


        for (int j = 0; j< n ; j++) {
            System.out.print("\n" + j +"");
            for(int i = 0;i <= j; i++) {
                System.out.print("  ");
            }
            System.out.print("*\n  ");
            for (int k : a) {
                System.out.print(" " + k);
            }
            if(a[j] == key) {
                index = j;
                break;
            }
        }
        System.out.println();
        return index;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};

        System.out.println(seqSearchSen(a, a.length,3));
    }
}

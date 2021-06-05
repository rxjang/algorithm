package chap02;

import java.util.Scanner;

public class ReverseArray2 {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
        System.out.println("\na[" + idx1 + "]과 a[" + idx2 +"]를 교환합니다.");
    }

    static void reverse(int[] a) {
        for( int i = 0; i < a.length / 2 ; i++) {
            for(int j : a){
                System.out.print(j + " ");
            }
            swap(a, i, a.length - i -1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0 ; i < num ; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);
        for(int j : x){
            System.out.print(j + " ");
        }

        System.out.println("\n역순정렬을 마쳤습니다.");
    }
}

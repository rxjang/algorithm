package chap02;

public class CloneArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();

        b[3] = 0;

        System.out.print("a = ");
        for (int j : a) {
            System.out.print(" " + j);
        }

        System.out.print("\nb = ");
        for(int i : b) {
            System.out.print(" " + i);
        }
    }
}

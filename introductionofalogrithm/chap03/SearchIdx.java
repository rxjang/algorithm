package chap03;

public class SearchIdx {

    static int searchIdx(int[] a, int n, int key, int[] idx) {

        int k = 0;
        for(int i = 0; i < n; i++) {
            if(a[i]==key) {
                idx[k++] = i;
            }
        }

        System.out.print("idx = {");
        for(int i = 0; i < n; i++) {
            if(idx[i] != 0) {
                System.out.print(" " + idx[i]);
            }
        }
        System.out.println("}");

        return k;
    }

    public static void main(String[] args) {

        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int n = a.length;
        int key  = 9;
        int[] idx = new int[n];

        System.out.println(searchIdx(a, n, key, idx));

    }


}

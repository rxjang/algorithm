package chap02;

public class CopyEg {

    static void copy(int[] a, int[] b) {
        //배열 b의 모든 요소를 배열 a에 복사
        for(int i = 0; i<b.length; i++) {
            a[i] = b[i];
        }
        print(a, b);
    }

    static void rcopy(int[]a, int[] b) {
        // 배열 b의 모든 요소를 배열 a에 역순으로 복사
        for(int i = 0; i < b.length ; i++){
            int temp = b.length - 1 - i;
            a[i] = b[temp];
        }

        print(a, b);
    }

    static void print(int[] a, int[] b){
        System.out.print("a = ");
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("\nb = ");
        for(int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] b = {1,2,3,4,5};

        int[] a = new int[b.length];

        copy(a, b);

        rcopy(a, b);


    }
}

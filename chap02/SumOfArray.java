package chap02;

public class SumOfArray {

    static int sumOf(int[] a) {
        int sum = 0;

        for(int i: a) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] x = {1,2,3,4};

        for(int i = 0; i < x.length; i++)
            System.out.print("x["+ i + "] = " + x[i] + " ");

        System.out.println("sum = " + sumOf(x));
    }
}

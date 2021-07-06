package chap05;


import java.util.Scanner;

public class GcdArray {

    static int gcdArray(int[] a) {
        if(a.length == 1) {
            return a[0];
        } else {
            int[] b = new int[a.length - 1];
            int x = a[0];
            int y = a[a.length - 1];
            while (y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }
            b[0] = x;
            for(int i = 1; i< b.length; i++) {
                b[i] = a[i];
            }
        return gcdArray(b);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
        int num;
        do {
            num = stdIn.nextInt();
        } while (num <= 1);

        int[] x = new int[num]; // 길이 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x) + "입니다.");
    }

}

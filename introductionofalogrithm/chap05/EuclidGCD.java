package chap05;

import java.util.Scanner;

public class EuclidGCD {

    static int gcd(int x, int y) {
        if(y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    static int gcd2(int x, int y) {
        int temp = Math.min(x, y);
        for(int i = temp; i > 1; i--) {
            if(x%i == 0 && y%i == 0) {
                return i;
            }
        }
        return 1;
    }

    static int gcd3(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");
        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요.: ");
        int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd2(x, y) + "입니다.");
    }
}

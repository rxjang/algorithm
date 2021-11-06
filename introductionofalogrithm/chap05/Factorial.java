package chap05;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n) {
        if(n > 0) {
            return n * factorial(n-1);
        } else {
            return 1;
        }
    }

    static int factorial2(int n) {
        int result = n;
        for(int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팰토리얼은 " + factorial2(x) + "입니다. ");
    }
}

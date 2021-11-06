package chap01;

import java.util.Scanner;

public class SumWhileEx {

    static int minusAFromB() {
        Scanner stdIn = new Scanner(System.in);
        int result, a, b;

        System.out.print("a 값: ");
        a = stdIn.nextInt();

        do {
            System.out.print("b 값: ");
            b = stdIn.nextInt();
            if( a > b ) {
                System.out.println("a 보디 큰 값을 입력하세요");
            }
        } while ( a > b);

        result = b - a;

        return result;
    }

    static int lengthOfNumber(int a) {
        String temp = String.valueOf(a);

        return temp.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfNumber(199) + "자리수 입니다.");
        System.out.println("b - a = " + minusAFromB());
    }
}

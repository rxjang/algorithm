package chap01;

import java.util.Scanner;

public class SumForEx {

    static String plusEx(int n) {
        String result = "";
        int sum = 0;

        for(int i = 1; i < n ; i++) {
            result += i + " + ";
            sum += i;
        }
        sum += n;
        result += n + " = " + sum;

        return result;
    }

    static int gauss(int n) {
        int sum = (1+n) * (n/2);
        if(n%2 == 1) {
            sum += n/2 + 1;
        }
        return sum;
    }

    static int sumof(int a, int b) {
        int sum = 0;

        if(a < b) {
            while(a<=b) {
                sum+=a;
                a++;
            }
        } else if (b < a) {
            while(b <= a) {
                sum +=b;
                b ++;
            }
        } else {
            sum = a;
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(plusEx(7));
        System.out.println(gauss(4));
        System.out.println(sumof(5,3));

    }
}

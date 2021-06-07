package chap02;

import java.util.Scanner;

public class LeftDayOfYear {

    static int [][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int leftDayOfYear(int y, int m, int d) {

        int sum = 0;
        sum += mdays[isLeap(y)][m-1] - d;

        while (m == 11) {
            sum += mdays[isLeap(y)][m++];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("그 해 경과 일 수 를 구합니다.");

        System.out.print("년 : ");
        int year = stdIn.nextInt();
        System.out.print("월 : ");
        int month = stdIn.nextInt();
        System.out.print("일 : ");
        int day = stdIn.nextInt();

        System.out.printf("그 해 %d일이 남았습니다. \n", leftDayOfYear(year, month, day));
    }
}

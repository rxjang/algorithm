package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitGenerator2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strNum = br.readLine();
        int num = Integer.parseInt(strNum);
        int value = 0;

        for(int i = num - strNum.length() * 9; i < num; i++) {
            int number = i;
            int sum = 0;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(i + sum == num) {
                value = i;
                break;
            }
        }

        System.out.println(value);
    }

}

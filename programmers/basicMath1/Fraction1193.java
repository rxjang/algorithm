package programmers.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fraction1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int x = 1;
        int temp = 1;
        int y = 1;
        int xv = 1;
        int plus = 4;

        while(xv <num) {
            x++;
            temp = xv;
            if(x % 2 == 0) {
                xv++;
            } else {
                xv += plus;
                plus +=4;
            }
        }
        if(xv != num) {
            int tempCha = num - temp;
            int valueCha = xv - num;
            if(tempCha == valueCha) {
                y = x;
                x = 1;
            } else if(tempCha < valueCha) {
                x--;
                while(temp != num) {
                    temp ++;
                    y++;
                    x--;
                }
            } else {
                while(xv != num) {
                    xv --;
                    y++;
                    x--;
                }
            }
        }

        System.out.println(y + "/" + x);
    }
}

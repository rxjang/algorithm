package programmers.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HERMAN3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        double circle = num * num * Math.PI;
        double square = num * num * 2;

        System.out.printf("%.6f\n", circle);
        System.out.printf("%.6f",square);
    }
}

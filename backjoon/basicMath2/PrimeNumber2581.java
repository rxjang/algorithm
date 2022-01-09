package backjoon.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[end - start + 1];

        for(int i = start; i<= end; i++) {
            if(i == 1) continue;
            if(i !=2 && i % 2 == 0) continue;

            boolean check = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    check = false;
                    break;
                }
            }
            arr[i-start] = check;
        }

        int min = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(min == 0 && arr[i]) min = (i + start);
            if(arr[i]) sum += (i + start);
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.printf("%d\n%d%n", sum, min);
        }
    }
}

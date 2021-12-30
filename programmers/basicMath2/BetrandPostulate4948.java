package programmers.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BetrandPostulate4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[123456 * 2 +1];

        arr[0] = arr[1] = true;

        for(int i = 2; i < Math.sqrt(123456 * 2); i++) {
            for(int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        while(true) {
            int start = Integer.parseInt(br.readLine());
            if(start == 0) break;
            int end = start * 2;
            int count = 0;
            for(int i = start + 1; i <= end; i++) {
                if(!arr[i]) count++;
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}

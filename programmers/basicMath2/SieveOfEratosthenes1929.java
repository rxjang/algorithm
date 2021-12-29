package programmers.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SieveOfEratosthenes1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];

        arr[0] = arr[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            for(int j = i*i ; j < arr.length ; j += i) {
                if(arr[j]) continue;
                arr[j] = true;
            }
        }

        for(int i = M; i <= N; i++) {
            if(!arr[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);

    }
}

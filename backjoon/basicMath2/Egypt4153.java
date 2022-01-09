package backjoon.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Egypt4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if(arr[0] == 0) break;
            Arrays.sort(arr);

            if(Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]) == arr[2]) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

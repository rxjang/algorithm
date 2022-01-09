package backjoon.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlphaCentauri1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int length = (Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken())) * -1;
            int rv = (int) Math.ceil(Math.sqrt(length));

            int value = rv * 2 - 1;

            if(length <= (rv * rv - rv)) {
                value -= 1;
            }
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}

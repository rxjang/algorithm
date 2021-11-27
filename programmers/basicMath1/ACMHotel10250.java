package programmers.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMHotel10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            int y = customer % height;
            int x = customer / height + 1;

            if(y == 0) {
                y = height;
                x--;
            }

            if(x < 10) {
                sb.append(y).append("0").append(x);
            } else {
                sb.append(y).append(x);
            }
            sb.append('\n');
        }


        System.out.println(sb);
    }
}

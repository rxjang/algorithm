package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulk7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] bulk = new int[num][2];

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            bulk[i][0] = Integer.parseInt(st.nextToken());
            bulk[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num; i++) {
            int rank = 1;
            for(int j = 0; j < num; j++) {
                if(i == j) continue;

                if(bulk[i][0] < bulk[j][0] && bulk[i][1] < bulk[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}

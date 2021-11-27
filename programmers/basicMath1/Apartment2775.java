package programmers.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Apartment2775 {
    public static void main(String[] args) throws IOException {
        int[][] apt = new int[15][15];

        for(int i = 0; i < 14; i++) {
            apt[0][i] = i;
            apt[i][0] = 0;
            apt[i][1] = 1;
            apt[i][2] = i + 2;
        }

        for(int i = 1; i < 14; i++) {
            for(int j = 2; j < 14; j++) {
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int times = Integer.parseInt(br.readLine());

        for(int i = 0; i < times; i++) {
            int row = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            sb.append(apt[row][ho]).append("\n");
        }

        System.out.println(sb);
    }
}

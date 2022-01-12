package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RepaintingTheChessboard1018 {
    static char[] w;
    static char[] b;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertical = Integer.parseInt(st.nextToken());
        int horizontal = Integer.parseInt(st.nextToken());

        arr = new char[vertical][horizontal];

        for (int i = 0; i < vertical; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < horizontal; j++) {
                arr[i][j] = temp[j];
            }
        }

        w = new char[horizontal];
        b = new char[horizontal];

        for(int i = 0; i < horizontal; i++) {
            w[i] = i % 2 == 0 ? 'W' : 'B';
            b[i] = i % 2 == 0 ? 'B' : 'W';
        }

        int answer = 64;

        for(int i = 0; i < vertical - 7; i++) {
            for(int j = 0; j < horizontal - 7; j++) {
                answer = Math.min(answer, findMinCase(i, j));
            }
        }

        System.out.println(answer);
    }


    public static int findMinCase(int x, int y) {
        int wCase = 0;
        int bCase = 0;

        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                boolean wRight = arr[i][j] == w[j];
                boolean bRight = arr[i][j] == b[j];

                if (i % 2 == 0) {
                    if (wRight) wCase++;
                    if (bRight) bCase++;
                } else {
                    if (bRight) wCase++;
                    if (wRight) bCase++;
                }
            }
        }
        return Math.min(wCase, bCase);
    }
}

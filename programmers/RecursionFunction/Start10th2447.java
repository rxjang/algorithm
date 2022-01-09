package programmers.RecursionFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다시 풀어보기
 */
public class Start10th2447 {

    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new boolean[num][num];
        StringBuilder sb = new StringBuilder();
        stars(0, 0, num, false);

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                sb.append(arr[i][j] ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void stars(int x, int y, int num, boolean blank) {

        // 공백일 경우
        if (blank) {
            for(int i = x; i < x + num; i++) {
                for(int j = y; j < y + num; j++) {
                    arr[x][y] = false;
                }
            }
            return;
        }

        // 들어온 값이 1일 경우
        if(num == 1) {
            arr[x][y] = true;
            return;
        }

        int count = 0;
        int value = num / 3;

        for(int i = x; i < x + num; i += value) {
            for(int j = y; j < y + num; j += value) {
                count ++;
                stars(i, j, value, count == 5);
            }
        }

    }



}

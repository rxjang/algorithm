package backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeConfetti2630 {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        arr = new int[num][num];

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, num);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int x, int y, int size) {

        if (checkColor(x, y, size)) {
            if(arr[x][y] == 0) {
                white ++;
            } else {
                blue ++;
            }
            return;
        }

        int newSize = size / 2;

        partition(x, y, newSize);
        partition(x, y + newSize, newSize);
        partition(x + newSize, y, newSize);
        partition(x + newSize, y + newSize, newSize);

    }

    public static boolean checkColor(int x, int y, int size) {

        int color = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

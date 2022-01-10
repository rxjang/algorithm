package backjoon.recursionFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi11729 {
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        move(num, 1, 3);

        System.out.println(count);
        System.out.println(sb);

    }

    // num개의 원반을 x번 기둥에서 y번 기둥으로
    static void move(int num, int x, int y) {
        count ++;
        if(num > 1) {
            move(num - 1, x, 6 - x - y);
        }
        sb.append(x).append(' ').append(y).append('\n');

        if(num > 1) {
            move(num -1, 6 - x - y, y);
        }
    }
}

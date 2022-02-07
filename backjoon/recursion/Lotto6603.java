package backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto6603 {

    static StringBuilder sb = new StringBuilder();
    static int num;
    static int[] numbers;
    static boolean[] print;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            if(num == 0) break;

            numbers = new int[num];
            print = new boolean[num];
            for(int i = 0; i < num; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void lotto(int start, int depth) {

        if (depth == 6) {
            for (int i = 0; i < num ; i++) {
                if(print[i]) {
                    sb.append(numbers[i]).append(" ");
                }
            }
            sb.append('\n');
        }

        for(int i = start; i < num; i++) {
            print[i] = true;
            lotto(i + 1, depth + 1);
            print[i] = false; // 출력하고 다시 사용하기 위해 false로 만듦
        }
    }
}

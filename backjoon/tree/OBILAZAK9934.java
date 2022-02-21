package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OBILAZAK9934 {

    static int[] arr;
    static StringBuilder[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        answers = new StringBuilder[num];
        for(int i = 0; i < answers.length; i++) {
            answers[i] = new StringBuilder();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[(int) (Math.pow(2, num) - 1)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        findNum(0, arr.length - 1, 0);

        for (StringBuilder answer : answers) {
            System.out.println(answer);
        }
    }

    static void findNum(int start, int end, int level) {
        if (level == answers.length) {
            return;
        }
        int num = (start + end) / 2;

        answers[level].append(arr[num]).append(" ");

        findNum(start, num - 1, level + 1);
        findNum(num + 1, end, level + 1);
    }
}

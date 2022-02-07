package backjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class JosephusProblem1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= Integer.parseInt(st.nextToken()); i++) {
            que.add(i);
        }
        int idx = Integer.parseInt(st.nextToken());
        while(que.isEmpty()) {
            int value = que.remove();
            sb.append(value).append(", ");
        }


        System.out.println(sb);
    }
}

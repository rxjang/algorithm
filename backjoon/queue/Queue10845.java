package backjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        int last = -1;

        for(int i = 0; i < num; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                st = new StringTokenizer(command, " ");
                st.nextToken();
                last = Integer.parseInt(st.nextToken());
                que.add(last);
            } else if (command.contains("pop")) {
                sb.append(que.isEmpty() ? -1 : que.poll()).append('\n');
            } else if (command.contains("size")) {
                sb.append(que.size()).append('\n');
            } else if (command.contains("empty")) {
                sb.append(que.isEmpty() ? 1 : 0).append('\n');
            } else if (command.contains("front")) {
                sb.append(que.isEmpty() ? -1 : que.peek()).append('\n');
            } else if (command.contains("back")) {
                sb.append(que.isEmpty() ? -1 : last).append('\n');
            }
        }

        System.out.println(sb);
    }
}

package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++) {
            String input = br.readLine();
            if(input.startsWith("push")) {
                st = new StringTokenizer(input, " ");
                st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
            } else if("pop".equals(input)) {
                int value;
                try {
                    value = stack.pop();
                } catch (EmptyStackException e) {
                    value = -1;
                }
                sb.append(value).append('\n');
            } else if("size".equals(input)) {
                sb.append(stack.size()).append('\n');
            } else if("empty".equals(input)) {
                sb.append(stack.empty() ? 1 : 0).append('\n');
            } else if("top".equals(input)) {
                int value;
                try {
                    value = stack.peek();
                } catch (EmptyStackException e) {
                    value = -1;
                }
                sb.append(value).append('\n');
            }
        }
        System.out.println(sb);
    }
}

package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence1874 {

    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int stackValue = 0;

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > stackValue) {
                while(value > stackValue) {
                    push(++stackValue);
                }
            }
            if(stack.peek() == value) {
                pop();
            } else {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int value) {
        stack.push(value);
        sb.append("+").append('\n');
    }

    public static void pop() {
        stack.pop();
        sb.append("-").append('\n');
    }
}

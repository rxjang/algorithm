package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num; i++) {
            sb.append(checkRight(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }

    public static String checkRight(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            Character value = input.charAt(i);
            if(stack.empty()) {
                stack.push(value);
                continue;
            }
            if('(' == stack.peek() && ')' == value) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }
        return stack.empty() ? "YES" : "NO";
    }
}

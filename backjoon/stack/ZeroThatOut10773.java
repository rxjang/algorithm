package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ZeroThatOut10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        int answer = 0;
        while(!stack.empty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}

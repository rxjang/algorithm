package leetCode.stack;

import java.util.Stack;

public class ValidateStackSequences946 {

    public static void main(String[] args) {

        int[] pushed = new int[]{1, 0};
        int[] popped = new int[]{1, 0};

        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for (int k : pushed) {
            stack.push(k);
            while(!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.empty();
    }
}

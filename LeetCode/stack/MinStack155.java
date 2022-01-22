package leetCode.stack;

import java.util.Stack;

public class MinStack155 {

    class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stack;

    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int val) {

        Node node = null;
        if(stack.isEmpty()) {
            node = new Node(val, val);
        } else {
            node = new Node(val, Math.min(stack.peek().min, val));
        }

        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

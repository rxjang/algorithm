package codeLatteDataStructure.Stack;

public class ArrayStack {
    int top = -1;
    final Object[] stack;

    public ArrayStack(int size) {
        this.stack = new Object[size];
    }

    /**
     * 데이터가 존재하는지 확인
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 데이터가 꽉 찾는지 확인
     */
    public boolean isFull() {
        return top == stack.length - 1;
    }

    /**
     * 데이터를 넣음
     */
    public void push(Object data) {

        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack 이 꽉 찼습니다");
        }

        stack[++top] = data;
    }

    /**
     * 데이터를 꺼냄
     */
    public Object pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack이 비었습니다.");
        }

        Object tempData = stack[top];
        stack[top--] = null;
        return tempData;
    }

    /**
     * 맨 위의 데이터가 무엇은지 확인
     */
    public Object peek() {

        return isEmpty() ? null : stack[top];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) {
            return "Empty Stack";
        }
        builder.append("bottom").append(" | ");
        for (int i = 0; i <= top; i++) {
            builder.append(stack[i]).append(" | ");
        }
        builder.append("top");
        return builder.toString();
    }
}

package codeLatteDataStructure.Stack;

public class StackTest {
    public static void main(String[] args) {

//        ArrayStack stack = new ArrayStack(4);
        ListStack<String> stack = new ListStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);

        System.out.printf("Pop된 데이터 %s\n", stack.pop());
        System.out.println(stack);

        System.out.printf("Pop된 데이터 %s\n", stack.pop());
        System.out.println(stack);

        stack.push("e");
        System.out.println(stack);

        System.out.printf("Peak된 데이터 %s\n", stack.peek());
        System.out.println(stack);

    }
}

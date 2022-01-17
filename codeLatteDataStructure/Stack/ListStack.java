package codeLatteDataStructure.Stack;

public class ListStack<T> {
    Node<T> head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if(!isEmpty()) {
            node.next = head;
        }
        head = node;
    }

    public T pop() {

        if(isEmpty()) {
            throw new RuntimeException("Stack이 비었습니다.");
        }
        Node<T> popNode = head;
        T data = popNode.data;
        head = popNode.next;

        popNode.next = null;
        popNode.data = null;
        return data;
    }

    public T peek() {
        return isEmpty() ? null : head.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) {
            return "Empty Stack";
        }
        builder.append("top").append(" | ");
        Node pointer = head;
        while (null != pointer) {
            builder.append(pointer.data).append(" | ");
            pointer = pointer.next;
        }
        builder.append("bottom");
        return builder.toString();
    }
}

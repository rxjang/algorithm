package codeLatteDataStructure.Queue;

public class ListQueue<T> {
    Node<T> front;
    Node<T> rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if(isEmpty()) {
            // queue가 비어 있으면 front에 새 노드를 저장
            front = node;
        } else {
            Node<T> prevNode = rear;
            // 이전 노드 next에 새 노드 저장
            prevNode.next = node;
        }
        // rear에 새 노드 저장
        rear = node;
    }

    public T poll() {
        if(isEmpty()) {
            throw new RuntimeException("Queue가 비었습니다");
        }
        Node<T> node = front;
        T data = node.data;
        // 프론트에 다음 값 저장
        front = node.next;
        if(node == rear) {
            // node가 한개일 경우. rear도 null 처리
            rear = null;
        }
        return data;
    }

    public T peek() {
        return isEmpty() ? null : rear.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> cursor = front;
        builder.append("앞").append("->");
        while (null != cursor) {
            builder.append(cursor.data).append("->");
            cursor = cursor.next;
        }
        builder.append("뒤");
        return builder.toString();
    }

}

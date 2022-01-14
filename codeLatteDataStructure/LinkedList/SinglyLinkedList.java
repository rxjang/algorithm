package codeLatteDataStructure.LinkedList;

public class SinglyLinkedList<T> {

    Node<T> head;
    int size = 0;

    // 노드 찾기
    public Node<T> findNode(int searchIdx) {

        // 연결 리스트 개수가 음수이거나, 찾으려는 idx가 size보다 크면 예외 던짐
        if(size <  0 || searchIdx > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int idx = 0;
        Node<T> pointer = head;
        while(idx != searchIdx) {
            ++idx;
            // 다음 노드로 이동
            pointer = pointer.next;
        }
        return pointer;
    }

    // 찾은 노드의 값 반환
    public T getData(int searchIdx) {
        return (T) findNode(searchIdx).data;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public int size() {
        return size;
    }

    public void addLast(Object data) {
        add(size, data);
    }

    public void addFirst(Object data) {
        add(0, data);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeFirst() {
        remove(0);
    }

    // 노드 삽입
    public void add(int idx, Object data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (idx == 0) {
            // 노드의 처음에 삽입하는 경우
            newNode.next = head;
            head = newNode;
        } else {
            // 원하는 위치에 삽입하려고 할 시, 노드들의 연결에 주의
            Node<T> findNode = findNode(idx - 1);
            newNode.next = findNode.next;
            findNode.next = newNode;
        }
        // 사이즈 늘리는 것 잊지 말기
        ++size;
    }

    public void remove(int idx) {
        if(idx == 0 && head != null) {
            head = head.next;
        } else {
            // 삭제하려는 노드의 이전의 노드
            Node<T> findNode = findNode(idx - 1);
            findNode.next = findNode.next.next;
        }
        --size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }


}

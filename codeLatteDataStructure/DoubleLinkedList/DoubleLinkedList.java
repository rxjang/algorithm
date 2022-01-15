package codeLatteDataStructure.DoubleLinkedList;

public class DoubleLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public Node<T> findNode(int searchIdx) {

        if(searchIdx < 0 || searchIdx >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T> pointer;
        int index;
        if (size / 2 > searchIdx) {
            pointer = head;
            index = 0;
            while (index != searchIdx) {
                pointer = head.right;
                index ++;
            }
        } else {
            pointer = tail;
            index = size - 1;
            while(index != searchIdx) {
                pointer = tail.left;
                index --;
            }
        }
        return pointer;
    }

    public void add(int idx, T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (size == 0 && idx == 0) {
            head = node;
            tail = node;
        } else if (idx == 0) {
            Node<T> firstNode = head;
            firstNode.left = node;
            head = node;
            node.right = firstNode;
        } else if (idx == size) {
            Node<T> lastNode = tail;
            lastNode.right = node;
            node.left = lastNode;
            tail = node;
        } else {
            Node<T> nextNode = findNode(idx - 1);
            Node<T> previousNode = nextNode.left;
            node.right = nextNode;
            nextNode.left = node;
            node.left = previousNode;
            previousNode.right = nextNode;
        }
        size++;
    }

    public void remove(int idx) {
        Node<T> findNode = findNode(idx);
        Node<T> nextNode = findNode.right;
        Node<T> prevNode = findNode.left;

        if (nextNode != null) {
            nextNode.left = prevNode;
        }
        if (prevNode != null) {
            prevNode.right = nextNode;
        }
        if (idx == 0) {
            head = nextNode;
        }
        if (idx == size - 1) {
            tail = prevNode;
        }

        findNode.right = null;
        findNode.left = null;
        findNode.data = null;
        size--;
    }


    public T getData(int searchIdx) {
        return findNode(searchIdx).data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T data) {
        add(size, data);
    }

    public void addFirst(T data) {
        add(0, data);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeFirst() {
        remove(0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.right;
        }
        stringBuilder.append("null ");
        if (null != tail) {
            stringBuilder.append(", tail(").append(tail.data).append("), ");
        }
        pointer = tail;
        stringBuilder.append("tail").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.left;
        }
        stringBuilder.append("null");
        if (null != head) {
            stringBuilder.append(", head(").append(head.data).append(")");
        }
        return stringBuilder.toString();
    }

}

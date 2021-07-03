package chap04;

public class Gqueue<E> {

    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    public static class EmptyGqueueException extends RuntimeException {
        public EmptyGqueueException () {}
    }

    public static class OverflowGqueueException extends RuntimeException {
        public OverflowGqueueException() {}
    }

    public Gqueue(int capacity) {
        max = capacity;
        num = front = rear = 0;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enque(E e) throws OverflowGqueueException {
        if(num >= max) {
            throw new OverflowGqueueException();
        }
        que[rear++] = e;
        num ++;
        if(rear == max) rear = 0;
        return e;
    }

    public E deque() throws EmptyGqueueException {
        if(num <=0) {
            throw new EmptyGqueueException();
        }
        num--;
        E value = que[front++];
        if(front == max) front = 0;
        return value;
    }

    public E peak() throws EmptyGqueueException {
        if(num <= 0) {
            throw new EmptyGqueueException();
        }
        return que[front];
    }

    public int indexOf(E e) {
        for(int i = 0; i < num; i++) {
            int idx = (front + i) % max;
            if(que[idx] == e)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public void dump() {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            System.out.print(que[idx] + " ");
        }
    }
}

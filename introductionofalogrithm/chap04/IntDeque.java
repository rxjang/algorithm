package introductionofalogrithm.chap04;

public class IntDeque {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public static class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() {}
    }

    public static class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() {}
    }

    public IntDeque(int capacity) {
        max = capacity;
        num = front = rear = 0;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueFront(int x) throws OverflowIntDequeException {
        if(num >= max) {
            throw new OverflowIntDequeException();
        }
        num++;
        if (--front < 0)
            front = max - 1;
        que[front] = x;
        return x;
    }

    public int dequeFront() throws EmptyIntDequeException {
        if(num <= 0) {
            throw new EmptyIntDequeException();
        }
        int value = que[front++];
        if(front == max) front = 0;
        num --;
        return value;
    }

    public int enqueRear(int x) throws OverflowIntDequeException {
        if(num >= max) {
            throw new OverflowIntDequeException();
        }
        que[rear++] = x;
        num ++;
        if(rear == max) rear = 0;

        return x;
    }

    public int dequeRear() throws EmptyIntDequeException {
        if(num <= 0) {
            throw new EmptyIntDequeException();
        }
        num--;
        if(--rear < 0) {
            rear = max -1;
        }
        return que[rear];
    }

    public void dump() {
        for(int i = 0; i < num; i++){
            int idx = (i + front) % max;
            System.out.print(que[idx] + " ");
        }
        System.out.println();
    }

    public int size() {
        return num;
    }

    public int capacity() {
        return max;
    }
}

package introductionofalogrithm.chap04;

public class IntArrayQueue {
    private int max;    // 큐 용량
    private int num;    // 현재 데이터 수
    private int[] que;   // 큐 본체

    public static class EmptyIntArrayQueException extends RuntimeException {
        public EmptyIntArrayQueException() {}
    }

    public static class OverflowIntArrayQueException extends RuntimeException {
        public OverflowIntArrayQueException() {}
    }

    public IntArrayQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int x) throws OverflowIntArrayQueException {
        if(num >= max) {
            throw new OverflowIntArrayQueException();
        }
        return que[num++] = x;
    }

    public int dequeue() throws EmptyIntArrayQueException {
        if(num <= 0) {
            throw new EmptyIntArrayQueException();
        }
        int value = que[0];
        for(int i = 0; i < num - 1; i++) {
            que[i] = que[i + 1];
        }
        num --;
        return value;
    }

    public int front() throws EmptyIntArrayQueException {
        if(num <= 0) {
            throw new EmptyIntArrayQueException();
        }
        return que[0];
    }

    public int rear() throws EmptyIntArrayQueException {
        if(num <= 0) {
            throw new EmptyIntArrayQueException();
        }
        return que[num-1];
    }

    public void dump() throws EmptyIntArrayQueException {
        if(num <= 0) {
            throw new EmptyIntArrayQueException();
        }
        for(int i = 0; i < num; i++) {
            System.out.print(que[i] + " ");
        }
    }

    public void clear() {
        num = 0;
    }

    public int size() {
        return num;
    }

    public int capacity() {
        return max;
    }
}

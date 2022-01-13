package introductionofalogrithm.chap04;

public class GStack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() {}
    }

    public static class OverflowGStackException extends RuntimeException {
        public OverflowGStackException() {}
    }

    public GStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object [max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E e) throws OverflowGStackException {
        if(ptr >= max) {
            throw new OverflowGStackException();
        }
        return stk[ptr++] = e;
    }

    public E pop() throws EmptyGStackException {
        if(ptr <= 0) {
            throw new EmptyGStackException();
        }
        return stk[--ptr];
    }

    public E peak() throws EmptyGStackException {
        if(ptr <= 0) {
            throw new EmptyGStackException();
        }
        return stk[ptr -1];
    }

    public int indexOf(E e) throws EmptyGStackException {
        for(int i = ptr - 1 ; i >=0 ; i--) {
            if(stk[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if(ptr <= 0) {
            System.out.println("스택이 비었습니다.");
        }
        for(int i = 0; i< ptr; i++) {
            System.out.print(stk[i] + " ");
        }
        System.out.println();
    }
}

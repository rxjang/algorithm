package chap04;

public class IntStackX {
    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    public static class EmptyStackXException extends RuntimeException {
        public EmptyStackXException() {}
    }

    public static class OverflowStackXException extends RuntimeException {
        public OverflowStackXException() {}
    }

    public IntStackX(int capacity) {
        ptrA = 0;
        ptrB = capacity - 1;
        max = capacity;
        try {
            stk = new int [max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int ptr, int i) throws OverflowStackXException {

        if(ptrB - ptrA < 0) {
            throw new OverflowStackXException();
        }
        if(ptr == 1) {
            return stk[ptrA++] = i;
        } else {
            return stk[ptrB--] = i;
        }
    }

    public int pop(int ptr) throws EmptyStackXException {
        if(ptr == 1) {
            if(ptrA <= 0) {
                throw new EmptyStackXException();
            }
            return stk[--ptrA];
        } else {
            if(ptrB >= max - 1) {
                throw new EmptyStackXException();
            }
            return stk[++ptrA];
        }
    }

    public int peek(int ptr) throws EmptyStackXException {
        if(ptr == 1) {
            if(ptrA <= 0) {
                throw new EmptyStackXException();
            }
            return stk[ptrA -1];
        } else {
            if(ptrB >= max) {
                throw new EmptyStackXException();
            }
            return stk[ptrB + 1];
        }
    }

    public int sizeA() {
        return ptrA;
    }
    public int sizeB() {
        return max - ptrB -1;
    }

    public int capacity() {
        return max;
    }
}

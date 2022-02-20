package codeLatteDataStructure.Tree;

import java.util.Arrays;

public class MaxHeap {
    int[] queue;
    int size = 0;

    public MaxHeap() {
        queue = new int[4];
    }

    public void add(int data) {
        if (queue.length == size) {
            queue = Arrays.copyOf(queue, size * 2);
        }
        queue[size++] = data;
        upHeap(size - 1);
    }

    public int remove() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is Empty");
        }
        int data = queue[0];
        swap(0, size - 1);
        queue[size - 1] = 0;
        --size;
        downHeap(0);
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is Empty");
        }
        return queue[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    boolean isExistLeftChild(int index) {
        return size > leftChildIndex(index);
    }

    boolean isExistRightChild(int index) {
        return size > rightChildIndex(index);
    }

    private void upHeap(int index) {
        if (index <= 0) {
            return;
        }
        int parentIndex = parentIndex(index);
        if (queue[index] > queue[parentIndex]) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }

    private void downHeap(int index) {
        if (!isExistLeftChild(index)) {
            return;
        }
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        if (isExistLeftChild(index)) {
            int maxValue = Math.max(queue[index], Math.max(queue[leftChildIndex], queue[rightChildIndex]));

            if (maxValue == queue[leftChildIndex]) {
                swap(leftChildIndex, index);
                downHeap(rightChildIndex);
            } else if (maxValue == queue[rightChildIndex]) {
                swap(rightChildIndex, index);
                downHeap(rightChildIndex);
            }
        } else {
            int maxValue = Math.max(queue[index], queue[leftChildIndex]);
            if (maxValue == queue[leftChildIndex]) {
                swap(leftChildIndex, index);
                downHeap(leftChildIndex);
            }
        }
    }

    private void swap(int index, int index2) {
        int tempValue = queue[index];
        queue[index] = queue[index2];
        queue[index2] = tempValue;
    }

    private void printHelper(int visitIndex, String indent, boolean last) {
        if (isEmpty()) {
            System.out.println("Heap is Empty");
            return;
        } else if (size <= visitIndex) {
            return;
        }

        System.out.print(indent);
        if (last) {
            System.out.print("R----");
            indent += "   ";
        } else {
            System.out.print("L----");
            indent += "|  ";
        }

        System.out.println(queue[visitIndex]);
        printHelper(visitIndex * 2 + 1, indent, false);
        printHelper(visitIndex * 2 + 2, indent, true);

    }

    public void printTree() {
        printHelper(0, "", true);
    }
}

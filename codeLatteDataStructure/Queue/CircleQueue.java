package codeLatteDataStructure.Queue;

public class CircleQueue {
    private final Object[] queue;
    private int front = 0;
    private int rear = 0;

    public CircleQueue(int size) {
        this.queue = new Object[size];
    }

    /**
     * 데이터를 넣음
     */
    public void add(Object data) {
        if(front == rear && queue[rear] != null) {
            throw new RuntimeException("Queue가 꽉 찼습니다.");
        }
        queue[rear] = data;
        rear = (rear + 1) % queue.length;
    }

    /**
     * 데이터를 꺼냄
     */
    public Object poll() {
        if(front == rear && queue[front] == null) {
            throw new RuntimeException("Queue가 비었습니다.");
        }
        Object data = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        return data;
    }

    /**
     * 꺼낼 데이터를 확인
     */
    public Object peek() {

        return queue[front];
    }

    @Override
    public String toString() {
        int tempFront = front;
        int tempRear = rear;
        StringBuilder builder = new StringBuilder();
        builder.append("앞").append("->");
        // TODO : front와 rear가 동일한 경우 두 가지가 경우가 있음
        // TODO : Queue가 비어있거나 또는 꽉 차있을 때
        if (tempFront == tempRear && null != queue[tempFront]) {
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        while (tempFront != tempRear) {
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        builder.append("뒤");
        return builder.toString();
    }

}

package codeLatteDataStructure.Queue;

public class QueueTest {
    public static void main(String[] args) {

//        CircleQueue queue = new CircleQueue(3);
        ListQueue<String> queue = new ListQueue<>();
        System.out.println("1 추가");
        queue.add("1");
        System.out.println("2 추가");
        queue.add("2");
        System.out.println("3 추가");
        queue.add("3");
        System.out.println(queue);

        System.out.printf("poll : %s\n", queue.poll());
        System.out.println(queue);

        System.out.println("4 추가");
        queue.add("4");
        System.out.println(queue);

        System.out.printf("poll : %s\n", queue.poll());
        System.out.printf("poll : %s\n", queue.poll());
        System.out.println(queue);

        System.out.println("5 추가");
        queue.add("5");
        System.out.println("6 추가");
        queue.add("6");
        System.out.println(queue);

        System.out.printf("poll : %s\n", queue.poll());
        System.out.println(queue);

        System.out.printf("poll : %s\n", queue.poll());
        System.out.printf("poll : %s\n", queue.poll());
        System.out.println(queue);
    }
}

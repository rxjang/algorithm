package codeLatteDataStructure.SinglyLinkedList;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("1");
        System.out.println(list);

        list.addFirst("2");
        System.out.println(list);

        list.addLast("3");
        System.out.println(list);

        list.add(1, "4");
        System.out.println(list);

        list.add(2, "5");
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        System.out.printf("노드의 개수:%d\n", list.size());

        System.out.printf("1번 인덱스의 값:%s", list.getData(1));
    }
}

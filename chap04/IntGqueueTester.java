package chap04;

import java.util.Scanner;

public class IntGqueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Gqueue<String> s = new Gqueue<String>(5);

        while(true) {
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            String t;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    t = stdIn.next();
                    try{
                        s.enque(t);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try{
                        t = s.deque();
                        System.out.println("디큐한 데이터는 "+ t + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        t = s.peak();
                        System.out.println("피크한 데이터는 " + t + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e ) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}

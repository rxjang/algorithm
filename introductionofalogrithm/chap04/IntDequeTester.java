package introductionofalogrithm.chap04;

import java.util.Scanner;

public class IntDequeTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque s = new IntDeque(5);

        while(true) {
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐프론트 (2)디큐프론트 (3)인큐리어 (4)디큐리어 (5)덤프 (0)종료 : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.enqueFront(x);
                    } catch (IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try{
                        x = s.dequeFront();
                        System.out.println("디큐프론트한 데이터는 "+ x + "입니다.");
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.enqueRear(x);
                    } catch (IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 4:
                    try{
                        x = s.dequeRear();
                        System.out.println("디큐리어한 데이터는 "+ x + "입니다.");
                    } catch (IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 5:
                    s.dump();
                    break;
            }
        }
    }
}

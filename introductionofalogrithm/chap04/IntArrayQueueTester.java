package introductionofalogrithm.chap04;

import java.util.Scanner;

public class IntArrayQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntArrayQueue s = new IntArrayQueue(10);

        while(true) {
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)프론트 (4)리어 (5)덤프 (6)clear (0)종료 : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    // 인큐
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.enqueue(x);
                    } catch (IntArrayQueue.OverflowIntArrayQueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    // 디큐
                    try{
                        x = s.dequeue();
                        System.out.println("디큐한 데이터는 "+ x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    // 프론트
                    try {
                        x = s.front();
                        System.out.println("프론트 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueException e ) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4:
                    x = s.rear();
                    try {
                        System.out.println("리어 데이터는 " + x + "입니다.");
                    } catch (IntArrayQueue.EmptyIntArrayQueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 5:
                    try {
                        s.dump();
                    } catch (IntArrayQueue.EmptyIntArrayQueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 6:
                    s.clear();
                    break;

            }
        }
    }
}

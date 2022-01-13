package introductionofalogrithm.chap04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true) {
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)인덱스 (6)clear (7)isEmpty (8)isFull (0)종료 : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    // 푸쉬
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    // 팝
                    try{
                        x = s.pop();
                        System.out.println("팝한 데이터는 "+ x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e ) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    System.out.print("찾을 데이터: ");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if(idx == -1) {
                        System.out.println(x + "는 스텍에 없습니다.");
                    } else {
                        System.out.println(x + "는 인덱스 "+ idx +"에 있습니다.");
                    }
                    break;
                case 6:
                    s.clear();
                    break;
                case 7:
                    if(s.isEmpty()){
                        System.out.println("스택이 비어 있습니다.");
                    } else {
                        System.out.println("스택이 비어 있지 않습니다.");
                    }
                    break;
                case 8:
                    if(s.isFull()){
                        System.out.println("스택이 가득 찼습니다.");
                    } else {
                        System.out.println("스택이 가득 차지 않았습니다.");
                    }
                    break;

            }
        }
    }
}

package introductionofalogrithm.chap04;

import java.util.Scanner;

public class InStackXTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStackX s = new IntStackX(10);

        while(true) {
            System.out.println("A: " + s.sizeA() + " / B: " + s.sizeB() + " / capacity: " + s.capacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (0)종료 : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int ptr;
            int x;
            switch (menu) {
                case 1:
                    // 푸쉬
                    System.out.print("위치: ");
                    ptr = stdIn.nextInt();
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try{
                        s.push(ptr, x);
                    } catch (IntStackX.OverflowStackXException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    // 팝
                    try{
                        System.out.print("위치: ");
                        ptr = stdIn.nextInt();
                        x = s.pop(ptr);
                        System.out.println("팝한 데이터는 "+ ptr + " 의 " + x + "입니다.");
                    } catch (IntStackX.EmptyStackXException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    // 피크
                    try {
                        System.out.print("위치: ");
                        ptr = stdIn.nextInt();
                        x = s.peek(ptr);
                        System.out.println("피크한 데이터는 " + ptr + " 의 " + x + "입니다.");
                    } catch (IntStackX.EmptyStackXException e ) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
            }
        }
    }
}

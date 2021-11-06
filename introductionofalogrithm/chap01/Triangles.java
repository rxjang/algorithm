package chap01;

public class Triangles {

    static void triangleLB(int n) {
        // 왼쪽 아래가 직각인 이등변 삼각형 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
                if(j == i) break;
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        // 왼쪽 위가 직각인 이등변 삼각형 출력
        for(int i = 1; i <= n; i++) {
            for(int j = n; j > 0; j--) {
                System.out.print("* ");
                if(j == i) break;
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        // 오른쪽 위가 직각인 이등변 삼각형 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i <= j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        // 오른쪽 아래가 직각인 이등변 삼각형 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i + j)>=3) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void spira(int n) {
        // 피라미 출력
        int mark = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (2*n - 1); j++) {
                if( i+j >= n-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                if(i+j >= mark) break;
            }
            mark+=2;
            System.out.println();
        }
    }
    static void npira(int n) {
        int mark = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (2*n - 1); j++) {
                if( i+j >= n-1) {
                    System.out.print((i+1) +" ");
                } else {
                    System.out.print("  ");
                }
                if(i+j >= mark) break;
            }
            mark+=2;
            System.out.println();
        }
    }



    public static void main(String[] args) {
//        triangleLB(4);
//        triangleLU(4);
//        triangleRU(4);
//        triangleRB(4);
        npira(4);
        spira(4);

    }
}

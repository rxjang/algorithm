package chap01;

public class Median {

    static int med3(int a, int b, int c) {
        int max =a;
        int median;

        if(max < b) {
            max = b;
        }
        if(max < c) {
            max = c;
        }
        if(max == a) {
            median = Math.max(b, c);
        } else if(max == b) {
            median = Math.max(a,c);
        } else {
            median = Math.max(a, b);
        }

        return median;
//        if( a >= b ) {
//            if (b >= c) {
//                return b;
//            } else if ( a <= c) {
//                return a;
//            } else {
//                return c;
//            }
//        } else if (a > c) {
//            return a;
//        } else if (b > c){
//            return c;
//        } else {
//            return b;
//        }
    }

    public static void main(String[] args) {
        System.out.println("med3(18, 30, 90) = " + med3(17,29,90));
        System.out.println("med3(18, 30, 30) = " + med3(18,30,30));
    }
}

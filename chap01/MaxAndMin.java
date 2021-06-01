package chap01;

public class MaxAndMin {
    static int max4m( int a, int b, int c, int d) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        return max;
    }

    static int min3( int a, int b, int c ) {
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min;
    }

    static int min4( int a, int b, int c, int d ) {
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        if(min > d) min = d;
        return min;
    }

    public static void main(String[] args) {
        System.out.println("max4m(5, 9, 10, 3) = " +max4m(5,9,10,3));
        System.out.println("min3(4, 3, 8) = " + (min3(4,3,8)));
        System.out.println("min4(4, 3, 8, 1) = " + (min4(4,3,8, 1)));
    }
}

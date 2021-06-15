package chap03;

public class BinSearchX {

    static int binSearchX(int[] a, int n ,int key) {
        int pl = 0;
        int pr = n - 1;

        int result = -1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                for(int i = pc; i >= 0; i--) {
                    if(a[i] == key) {
                        result = i;
                    }
                }
                return result;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return result;
    }

    public static void main(String[] args) {

        int [] x = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int num = x.length;
        int key = 7;

        int idx = binSearchX(x, num, key);
        if(idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + " 은(는) x[" + idx + "]에 있습니다.");
        }
    }
}

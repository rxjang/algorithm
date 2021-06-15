package chap03;

public class BinSearchEx {

    static int binSearch(int[] a, int n ,int key) {
        int pl = 0;
        int pr = n - 1;

        System.out.print("   |");
        for(int i = 0; i < n; i++) {
            System.out.print("  " + i);
        }
        System.out.print("\n- -+");
        for(int i = 0; i < n; i++) {
            System.out.print("- -");
        }
        System.out.println();

        do {
            int pc = (pl + pr) / 2;
            System.out.print("   |");
            for(int i = 0; i < n; i++) {
                if(i == pl) {
                    System.out.print(" <- ");
                } else if (i == pc) {
                    System.out.print(" + ");
                } else if (i == pr) {
                    System.out.print(" ->");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n" + pc +"  | ");
            for(int i = 0; i < n; i++) {
                System.out.print(" " + a[i] +" ");
            }
            System.out.println();

            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {

        int[] x = { 1, 2, 3, 5, 6, 8, 9};
        int num = x.length;
        int key = 2;

        int idx = binSearch(x, num, key);
        if(idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + " 은(는) x[" + idx + "]에 있습니다.");
        }
    }
}

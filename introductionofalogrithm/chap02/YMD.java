package chap02;

public class YMD {

    int y;
    int m;
    int d;

    YMD(int y, int m, int d) {
        //  주어진 날짜로 설정
        this.y = y;
        this.m = m;
        this.d = d;
    }

    static int [][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d) {
        int days = d;

        for(int i = 1; i < m; i++) {
            days+= mdays[isLeap(y)][i-1];
        }
        return days;
    }

    YMD after(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return (before(-n));

        temp.d += n;

        while(temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m > 12) {
                temp.y++;
                temp.m = 1;
            }
        }

        return temp;
    }

    YMD before(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return (after(-n));

        temp.d -= n;

        while(temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }

        return temp;

    }

    public static void main(String[] args) {
        int y = 2021;
        int m = 6;
        int d = 8;

        YMD date = new YMD(y, m, d);
        YMD after = date.after(1);
        System.out.println(after.y + "." + after.m + "." + after.d);
        YMD before = date.before(1);
        System.out.println(before.y + "." + before.m + "." + before.d);

    }
}



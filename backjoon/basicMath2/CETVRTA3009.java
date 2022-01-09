package backjoon.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CETVRTA3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arrX = new int[3];
        int[] arrY = new int[3];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        System.out.printf("%d %d",
                arrX[0] == arrX[1] ? arrX[2]
                        : arrX[1] == arrX[2] ? arrX[0] : arrX[1],
                arrY[0] == arrY[1] ? arrY[2]
                        : arrY[1] == arrY[2] ? arrY[0] : arrY[1]);
    }
}

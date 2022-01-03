package programmers.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다시 풀어 보기
 */
public class Turret1002 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append("-1").append('\n');
                continue;
            }

            int squareDistance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2- y1, 2));
            int squareRadius = (int) Math.pow(r2 - r1, 2);
            int squareRadius2 = (int) Math.pow(r2 + r1, 2);

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append("-1");
            } else if(squareDistance == squareRadius2) {
                sb.append("1");
            } else if(squareDistance == squareRadius) {
                sb.append("1");
            } else if(squareRadius > squareDistance || squareRadius2 < squareDistance) {
                sb.append("0");
            } else {
                sb.append("2");
            }
            sb.append('\n');

        }

        System.out.println(sb);
    }
}

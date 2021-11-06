package programmers.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int day = Integer.parseInt(st.nextToken());
        int sleep = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        double a = day - sleep;
        double b = length - sleep;

        System.out.println((int)Math.ceil(b/a));
    }
}

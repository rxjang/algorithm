package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDirectorShawm1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int answer = 666;
        int count = 0;
        while(true) {
            String value = String.valueOf(answer);
            if(value.contains("666")) count++;

            if(count == num) {
                break;
            }
            answer += 1;
        }

        System.out.println(answer);
    }

}

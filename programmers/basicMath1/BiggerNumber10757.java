package programmers.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BiggerNumber10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        int length = Math.max(first.length(), second.length()) + 1;
        char[] answer = new char[length];
        Arrays.fill(answer, '0');

        int fl = first.length();
        for(int i = 0; i < length - fl; i++) {
            first = String.format("%s%s", '0' , first);
        }

        int sl = second.length();
        for(int i = 0; i < length - sl; i++) {
            second = String.format("%s%s", '0' , second);
        }

        int value = 0;
        for(int i = length -1; i > 0; i--) {
            value = (first.charAt(i) - '0') + (second.charAt(i) - '0') + (answer[i] - '0');
            answer[i] = (char) (value % 10 + '0');
            answer[i - 1] = (char) (value / 10 + '0');
        }

        StringBuilder sb = new StringBuilder();
        int start = answer[0] == '0' ? 1 : 0;
        for(int i = start; i < length; i++) {
            sb.append(answer[i]);
        }

        System.out.println(sb);
    }
}

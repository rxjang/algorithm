package backjoon.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimeNumber1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        while(st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());

            if(value == 2 || value == 3 || value == 5 || value == 7) {
                answer ++;
                continue;
            }

            if(value <= 10 || value % 2 == 0) continue;

            boolean primeNumber = true;
            for(int i = 3; i < value / 2; i += 2) {
                if(value % i == 0)  {
                    primeNumber = false;
                    break;
                }
            }
            if(primeNumber) answer ++;
        }

        System.out.println(answer);
    }

    // 다른 방법
    boolean isPrimeNumber(int value) {
        if(value == 1) {
            return false;
        }

        // 제곱근 보다 큰 수는 검사할 필요가 없음 (제곱근 이상의 수 끼리 곱하면 해당 수를 넘어버리기 때문)
        for(int i = 2; i <= Math.sqrt(value); i++) {
            if(value % i == 0) {
                return false;
            }
        }
        return true;
    }
}

package backjoon.basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachsConjecture9020 {

    public static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        primeNumbers();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            sb.append(findTwoPrimeNumbers(Integer.parseInt(br.readLine())))
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void primeNumbers() {
        arr[0] = arr[1] = true;
        for(int i = 2; i < Math.sqrt(arr.length); i++) {
            for(int j = i * 2; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }

    public static String findTwoPrimeNumbers(int value) {

        int first = value / 2;
        int second = 0;

        while(true) {
            first = findPrimeNumber(first);
            if(!arr[value - first]) {
                second = value - first;
                break;
            } else {
                first--;
            }
        }

        return String.format("%d %d", first, second);
    }

    public static int findPrimeNumber(int value) {
        for(int i = value; i > 1; i--) {
            if(!arr[i]) {
                value = i;
                break;
            }
        }
        return value;
    }
}

package programmers.RecursionFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbers10870 {
    public static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        fibonacci(num);
        System.out.println(arr[num]);
    }

    public static int fibonacci(int value) {
        if(value <= 1) return arr[value];
        arr[value] = fibonacci(value - 1) + fibonacci(value - 2);
        return arr[value];
    }
}

package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int temp;
        for(int i = 0; i < num; i++) {
            for(int j = i + 1; j < num; j++) {
                for(int k = j + 1; k < num; k++) {
                    temp = arr[i] + arr[j] + arr[k];
                    if(temp > target) continue;
                    if(target - temp < target - sum) sum = temp;
                    if(temp == target) break;
                }
            }
        }

        System.out.println(sum);
    }
}

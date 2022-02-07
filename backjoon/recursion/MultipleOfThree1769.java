package backjoon.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MultipleOfThree1769 {
    static int count = 0;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String num = br.readLine();
        String changedNum = addNumbers(num);
        String multipleOfThree = Integer.parseInt(changedNum) % 3 == 0 ? "YES" : "NO";

        sb.append(count)
                .append('\n')
                .append(multipleOfThree);

        System.out.println(sb);
    }

    public static String addNumbers(String num) {
        if(num.length() == 1) return num;

        count ++;
        int changeNum = 0;
        for(int i = 0; i < num.length(); i++) {
            changeNum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return addNumbers(String.valueOf(changeNum));
    }
}

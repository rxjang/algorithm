package backjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class TheBalanceoftheWorld4949 {

    static Stack<Character> bracket = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String sentence = br.readLine();

            if (sentence.equals(".")) {
                break;
            }

            sb.append(checkBalance(sentence.toCharArray()) ? "yes" : "no");
            sb.append("\n");

            bracket.clear();
        }

        System.out.println(sb);
    }

    static boolean checkBalance(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            char letter = arr[i];
            if (letter == '(' || letter == '[') {
                bracket.push(letter);
            } else if (letter == ')') {
                if (bracket.empty() || bracket.peek() != '(') {
                    return false;
                } else {
                    bracket.pop();
                }
            } else if (letter == ']') {
                if (bracket.empty() || bracket.peek() != '[') {
                    return false;
                } else {
                    bracket.pop();
                }
            }
        }

        return bracket.empty() ? true : false;
    }
}

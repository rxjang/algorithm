package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeRecovery6597 {

    static StringBuilder sb = new StringBuilder();
    static int[] pre, in, inIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value;

        while (true) {
            value = br.readLine();
            if(value == null || value.length() == 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(value);
            String preOrder = st.nextToken();
            String inOrder = st.nextToken();

            int size = preOrder.length();
            pre = new int[size + 1];
            in = new int[size];
            inIdx = new int[size];

            for (int i = 0; i < size; i++) {
                pre[i] = preOrder.charAt(i) - 'A';
                in[i] = inOrder.charAt(i) - 'A';
            }

            for (int i = 0; i < size; i++) {
                inIdx[in[i]] = i;
            }

            recover(0, 0, size);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void recover(int idx, int left, int right) {
        if (left >= right) {
            return;
        }
        int root = pre[idx];
        int rootIdx = inIdx[root];

        recover(idx + 1, left, rootIdx);
        recover(idx + 1 + (rootIdx - left), rootIdx + 1, right);
        sb.append((char)(root + 'A'));
    }
}

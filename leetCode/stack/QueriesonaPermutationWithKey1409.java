package leetCode.stack;

import java.util.Iterator;
import java.util.Stack;

public class QueriesonaPermutationWithKey1409 {

    public int[] processQueries(int[] queries, int m) {

        int[] answer = new int[queries.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = m; i > 0; i--) {
            stack.push(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            Iterator<Integer> it = stack.iterator();
            int idx = 0;
            while(it.hasNext()) {
                int value = it.next();
                if(temp == value) {
                    answer[i] = m - 1 -idx;
                    stack.remove(idx);
                    stack.push(value);
                    break;
                }
                idx++;
            }
        }

        return answer;
    }
}

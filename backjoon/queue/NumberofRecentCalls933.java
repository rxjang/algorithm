package backjoon.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls933 {
    Queue<Integer> que;

    public NumberofRecentCalls933() {
        que = new LinkedList<>();
    }

    public int ping(int t) {

        que.add(t);

        while (que.peek() < t - 3000) {
            que.poll();
        }

        return que.size();
    }
}

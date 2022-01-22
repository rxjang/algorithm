package leetCode.queue;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        Queue<Character> que = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            que.add(s.charAt(i));
        }

        int idx = -1;
        for(int i = 0; i < que.size(); i++) {
            char c = que.poll();
            Optional<Character> ch = que.stream().filter(q -> q == c).findAny();
            if(ch.isEmpty()) {
                idx = i;
                break;
            } else {
                que.add(c);
            }
        }
        return idx;
    }
}

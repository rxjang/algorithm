package leetCode.queue;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class NumberofStudentsUnabletoEatLunch1700 {

    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> que = new LinkedList<>();

            for(int i = 0; i < students.length; i++) {
                stack.add(sandwiches[students.length - 1 - i]);
                que.add(students[i]);
            }

            while(que.size() != 0) {
                int student = que.peek();
                int sandwich = stack.peek();
                if(student == sandwich) {
                    stack.pop();
                    que.poll();
                } else {
                    Optional<Integer> value = que.stream().filter(q -> q == sandwich).findAny();
                    if(value.isEmpty()) {
                        break;
                    } else {
                        que.add(que.poll());
                    }
                }
            }

            return que.size();
        }
    }
}

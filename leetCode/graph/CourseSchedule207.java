package leetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule207 {

    public static void main(String[] args) {
        canFinish(3, new int[][]{{1, 2},{2, 1}});
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> arr = new ArrayList<>();
        int[] indegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[0];
            int end = prerequisite[1];
            arr.get(end).add(start);
            indegree[start]++;
        }

        int count = 0;
        while (count < numCourses) {
            boolean courseTaken = false;
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    List<Integer> list = arr.get(i);
                    for (Integer x : list) {
                        indegree[x]--;
                    }
                    indegree[i]--;
                    courseTaken = true;
                    count++;
                }
            }
            if (!courseTaken) break;
        }

        return count == numCourses;
    }
}

package backjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze2178 {

    static int[][] maze;
    static boolean[][] visited;
    static int x;
    static int y;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        maze = new int[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            String value = br.readLine();
            for (int j = 0; j < y; j++) {
                maze[i][j] = value.charAt(j)- '0';
            }
        }

        findRoot(0, 0);

        System.out.println(maze[x - 1][y - 1]);
    }

    static void findRoot(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, m});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            visited[n][m] = true;

            for (int i = 0; i < 4; i++) {
                int r = location[0] + dx[i];
                int c = location[1] + dy[i];

                if (r >= 0 && c >= 0 && r < x && c < y) {
                    if (maze[r][c] != 0 && !visited[r][c]) {
                        queue.offer(new int[] {r,c});
                        visited[r][c] = true;
                        maze[r][c] = maze[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }
}

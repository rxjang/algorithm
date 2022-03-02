package codeLatteDataStructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrixGraph {

    final int[][] graph;

    int[] visit;

    public AdjacencyMatrixGraph(int size) {
        this.graph = new int[size][size];
    }

    // 무방향 간선
    public void addUndirectedEdge(int u, int v) {
        addUndirectedEdge(u, v, 1);
    }

    public void addUndirectedEdge(int u, int v, int w) {
        graph[u][v] = w;
        graph[v][u] = w;
    }

    // 방향 간선
    public void addDirectEdge(int u, int v) {
        addDirectEdge(u, v, 1);
    }

    public void addDirectEdge(int u, int v, int w) {
        graph[u][v] = w;
    }

    public void clear() {
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 0);
        }
    }


    public void dfsTraversal(int start) {
        visit = new int[graph.length];
        dfs(start);
    }

    private void dfs(int u) {
        if (visit[u] == 1) {
            return;
        }
        visit(u);
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != 0 && visit[v] == 0) {
                dfs(v);
            }
        }
    }

    private void visit(int vertex) {
        System.out.printf("%d", vertex);
        visit[vertex] = 1;
    }

    public void bfsTraversal(int start) {
        visit = new int[graph.length];
        bfs(start);
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && visit[v] == 0) {
                    queue.add(v);
                    visit(v);
                }
            }
        }
    }

    public void printEdge() {
        System.out.println("---Matrix Edge---");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (0 != graph[i][j]) {
                    System.out.printf("(%d, %d, %d) ", i, j, graph[i][j]);
                }
            }
        }
        System.out.println("\n-----------------");
    }
}

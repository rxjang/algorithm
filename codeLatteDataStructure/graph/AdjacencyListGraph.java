package codeLatteDataStructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph {

    final LinkedList<Edge>[] graph;
    final int[] visit;

    public AdjacencyListGraph(int size) {
        graph = new LinkedList[size];
        visit = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void clear() {
        for (int i = 0; i <graph.length; i++) {
            graph[i].clear();
        }
    }

    public void addEdge(int u, int v, int w) {
        Edge edge = new Edge(u, v, w);
        graph[u].add(edge);
        graph[u].sort((o1, o2) -> o1.v - o2.v);
    }

    public void addUndirectedEdge(int u, int v) {
        addUndirectedEge(u, v, 1);
    }

    public void addUndirectedEge(int u, int v, int w) {
        addEdge(u, v, w);
        addEdge(v, u, w);
    }

    public void addDirectEdge(int u, int v) {
        addDirectEdge(u, v, 1);
    }

    public void addDirectEdge(int u, int v, int w) {
        addEdge(u, v, w);
    }

    public void dfsTraversal(int start) {
        Arrays.fill(visit, 0);
        dfs(start);
    }

    private void dfs(int u) {
        if (visit[u] == 1) {
            return;
        }
        visit(u);
        for (Edge edge: graph[u]) {
            if (visit[edge.v] == 0) {
                dfs(edge.v);
            }
        }
    }

    public void bfsTraversal(int start) {
        Arrays.fill(visit, 0);
        bfs(start);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            visit(u);
            for (Edge edge: graph[u]) {
                if (visit[edge.v] == 0) {
                    queue.add(edge.v);
                    visit[edge.v] = 1;
                }
            }
        }
    }

    void visit(int vertex) {
        System.out.printf("verted:%d/n", vertex);
        visit[vertex] = 1;
    }

    public void printEdge() {
        System.out.println("---List Edge---");
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                System.out.printf("(%d, %d, %d) ", edge.u, edge.v, edge.w);
            }
        }
        System.out.println("\n---------------");
    }
}


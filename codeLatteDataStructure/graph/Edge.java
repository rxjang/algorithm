package codeLatteDataStructure.graph;

public class Edge {
    int u; // 출발지
    int v; // 도착지
    int w; // 가중치

    public Edge() {
    }

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

package codeLatteDataStructure.Tree;

public class Node {
    int key;
    Node left;
    Node right;

    // 노드의 높이 (for AVL)
    int height = 0;

    // Red-Black Tree 용
    Node parent;
    int color = RED;

    static final int RED = 0;
    static final int BLACK = 1;
}

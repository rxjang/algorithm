package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree5639 {
    static StringBuilder sb;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            int num = Integer.parseInt(input);

            Node newNode = new Node();
            newNode.value = num;

            if (root == null) {
                root = newNode;
            } else {
                insertNode(root, newNode);
            }

        }

        postOrder(root);
        System.out.println(sb);
    }

    public static Node insertNode(Node parent, Node newNode) {
        if (parent == null) {
            return newNode;
        }

        if (newNode.value < parent.value) {
            parent.left = insertNode(parent.left, newNode);
        } else {
            parent.right = insertNode(parent.right, newNode);
        }
        return parent;
    }

    public static void postOrder(Node parent) {
        if (parent == null) {
            return;
        }
        postOrder(parent.left);
        postOrder(parent.right);
        sb.append(parent.value).append('\n');
    }

}

class Node {
    int value;
    Node left;
    Node right;
}

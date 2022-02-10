package codeLatteDataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {

    Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            if (parentNode.left != null) {
                queue.offer(parentNode.left);
            } else {
                parentNode.left = newNode;
                break;
            }

            if (parentNode.right != null) {
                queue.offer(parentNode.right);
            } else {
                parentNode.right = newNode;
                break;
            }
        }
    }

    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            System.out.println(parentNode.key);

            if (parentNode.left != null) {
                queue.offer(parentNode.left);
            }

            if (parentNode.right != null) {
                queue.offer(parentNode.right);
            }
        }
    }
}

package leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> sameLevelNodes = new ArrayList<>();

            int queSize = queue.size();
            for (int i = 0; i < queSize; i++) {
                TreeNode parentNode = queue.poll();

                sameLevelNodes.add(parentNode.val);

                if(parentNode.left != null) {
                    queue.offer(parentNode.left);
                }
                if (parentNode.right != null) {
                    queue.offer(parentNode.right);
                }
            }
            lists.add(sameLevelNodes);
        }

        return lists;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

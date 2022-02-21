package leetCode.tree;

public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int answer = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                answer += root.left.val;
            } else {
                answer += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            answer += sumOfLeftLeaves(root.right);
        }

        return answer;
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

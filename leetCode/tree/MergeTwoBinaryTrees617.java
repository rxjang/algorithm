package leetCode.tree;

public class MergeTwoBinaryTrees617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1.val == 0 && root2.val == 0) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = root1.val + root2.val;

        TreeNode nullNode = new TreeNode();
        nullNode.val = 0;
        nullNode.left = null;
        nullNode.right = null;

        root.left = mergeTrees(root1.left == null ? nullNode : root1.left,
                root2.left == null ? nullNode : root2.left);

        root.right = mergeTrees(root1.right == null ? nullNode : root1.right,
                root2.right == null ? nullNode : root2.right);

        return root;
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

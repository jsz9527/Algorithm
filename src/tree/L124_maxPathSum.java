package tree;

public class L124_maxPathSum {

    int maxPathSum = 0;

    public int maxPathSum(TreeNode root) {
        if (root==null){
            return maxPathSum;
        }else {
            maxPathSum = root.val;
        }
        maxGain(root);
        return maxPathSum;
    }

    public int maxGain(TreeNode node) {
        if(node==null){
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int tempSum = node.val + leftGain + rightGain;

        maxPathSum = Math.max(maxPathSum, tempSum);

        return node.val + Math.max(leftGain, rightGain);
    }


}

class TreeNode {
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

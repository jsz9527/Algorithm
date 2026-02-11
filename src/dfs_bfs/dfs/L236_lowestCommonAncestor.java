package dfs_bfs.dfs;

import vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L236_lowestCommonAncestor {

    public static void main(String[] args) {
        String[] strings = new String[]{"3","5","1","6","2","0","8",null,null,"7","4"};

        // 创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1; // 从数组的第二个元素开始

        while (!queue.isEmpty() && index < strings.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (index < strings.length && strings[index] != null) {
                current.left = new TreeNode(Integer.parseInt(strings[index]));
                queue.offer(current.left);
            }
            index++;

            // 处理右子节点
            if (index < strings.length && strings[index] != null) {
                current.right = new TreeNode(Integer.parseInt(strings[index]));
                queue.offer(current.right);
            }
            index++;
        }

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);


        TreeNode result = new L236_lowestCommonAncestor().lowestCommonAncestor(root, p, q);
    }

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postOrder(root, p, q);
        return result;
    }

    public boolean postOrder(TreeNode node, TreeNode p, TreeNode q){
        boolean leftContainPOrQ = false;
        boolean rightContainPOrQ = false;
        if(node.left != null){
            leftContainPOrQ = postOrder(node.left, p, q);
        }
        if(node.right != null){
            rightContainPOrQ = postOrder(node.right, p, q);
        }

        if(result != null){
            return true;
        }

        if(leftContainPOrQ && rightContainPOrQ){
            result = node;
            return true;
        }else if( leftContainPOrQ || rightContainPOrQ ){
            if(node.val == p.val || node.val == q.val){
                result = node;
                return true;
            }else {
                return true;
            }
        }else {
            if(node.val == p.val || node.val == q.val){
                return true;
            }else {
                return false;
            }
        }

    }

}

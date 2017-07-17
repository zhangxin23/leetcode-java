package net.coderland.linear_list.binary_tree;

/**
 * Created by zhangxin on 17/7/17.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalancedHeight(root) >= 0;
    }

    private int isBalancedHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = isBalancedHeight(node.getLeft());
        int right = isBalancedHeight(node.getRight());

        if(left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}

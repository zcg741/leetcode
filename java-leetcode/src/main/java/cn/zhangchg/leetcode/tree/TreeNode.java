package cn.zhangchg.leetcode.tree;

import lombok.Data;

/**
 * 二叉树
 *
 * @author 张晨刚
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void printTree(TreeNode node, int high, StringBuffer sb) {
        if (node == null) {
            return;
        }
        printTree(node.right, high + 1, sb);
        for (int i = 0; i < high; i++) {
            sb.append(" ");
        }
        sb.append(node.val).append(" \n");
        printTree(node.left, high + 1, sb);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        printTree(this, getDepth(this), sb);
        return sb.toString();
    }
}

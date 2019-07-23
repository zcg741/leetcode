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

    @Override
    public String toString() {
        return val
                + (left != null ? "," + left : "")
                + (right != null ? "," + right : "");
    }
}

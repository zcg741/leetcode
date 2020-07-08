package cn.zhangchg.leetcode.tree;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * Related Topics 树 深度优先搜索 数组
 *
 * @author zcg74
 */
public class BuildTree {

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.err.println(treeNode);
        treeNode = buildTree.buildTree(new int[]{1, 2}, new int[]{1, 2});
        System.err.println(treeNode);
        treeNode = buildTree.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.err.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode top = new TreeNode(preorder[0]);
        int flag = -1;
        for (int i = 0; i <= preorder.length; i++) {
            if (top.val == inorder[i]) {
                flag = i;
                break;
            }
        }
        if (flag == -1) {
            return top;
        }
        if (flag >= 1) {
            TreeNode leftNode = buildTree(Arrays.copyOfRange(preorder, 1, flag + 1), Arrays.copyOfRange(inorder, 0, flag));
            top.left = leftNode;
        }
        if (flag < preorder.length - 1) {
            TreeNode rightNode = buildTree(Arrays.copyOfRange(preorder, flag + 1, preorder.length), Arrays.copyOfRange(inorder, flag + 1, preorder.length));
            top.right = rightNode;
        }
        return top;
    }
}

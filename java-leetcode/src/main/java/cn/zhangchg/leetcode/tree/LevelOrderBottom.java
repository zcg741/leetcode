package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * @author 张晨刚
 */
public class LevelOrderBottom {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(17);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(7);
        LevelOrderBottom levelOrder = new LevelOrderBottom();
        System.err.println(levelOrder.levelOrderBottom(treeNode));
    }

    List<List<Integer>> listNode = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return listNode;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        List<TreeNode> childNode = getChildNode(treeNodes);
        while (childNode.size() != 0) {
            childNode = getChildNode(childNode);
        }
        return listNode;
    }

    public List<TreeNode> getChildNode(List<TreeNode> nodes) {
        List<Integer> integers = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            integers.add(node.val);
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
        listNode.add(0, integers);
        return treeNodes;
    }
}

package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author 张晨刚
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(17);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        System.err.println(levelOrder.levelOrder(treeNode));
    }

    List<List<Integer>> listNode = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        listNode.add(integers);
        return treeNodes;
    }
}

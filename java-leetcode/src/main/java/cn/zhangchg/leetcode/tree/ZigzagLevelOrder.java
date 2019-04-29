package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author 张晨刚
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(17);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(7);
        ZigzagLevelOrder levelOrder = new ZigzagLevelOrder();
        System.err.println(levelOrder.zigzagLevelOrder(treeNode));
    }

    List<List<Integer>> listNode = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return listNode;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        int i = 1;
        List<TreeNode> childNode = getChildNode(treeNodes, i++);
        while (childNode.size() != 0) {
            childNode = getChildNode(childNode, i++);
        }
        return listNode;
    }

    public List<TreeNode> getChildNode(List<TreeNode> nodes, int flag) {
        List<Integer> integers = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        if (flag % 2 == 0) {
            for (TreeNode node : nodes) {
                integers.add(node.val);
            }
        } else {
            for (int i = nodes.size() - 1; i >= 0; i--) {
                TreeNode treeNode = nodes.get(i);
                integers.add(treeNode.val);
            }
        }
        for (TreeNode node : nodes) {
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

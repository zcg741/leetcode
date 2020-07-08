package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * Related Topics 树 深度优先搜索
 * DFS
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(3);
        treeNode1.right.right = new TreeNode(5);
        treeNode.left = treeNode1;
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.err.println(binaryTreePaths.binaryTreePaths(treeNode));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
    public List<String> binaryTreePathsd(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add("" + root.val);
            return list;
        }
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        leftList.forEach(leftString -> {
            list.add(root.val + "->" + leftString);
        });
        rightList.forEach(rightString -> {
            list.add(root.val + "->" + rightString);
        });
        return list;
    }

}

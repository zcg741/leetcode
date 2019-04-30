package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author 张晨刚
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum numTrees = new PathSum();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(-2);
        treeNode.right.left.left = new TreeNode(1);
        System.err.println(numTrees.pathSum(treeNode, -1));
        System.err.println(numTrees.pathSum(treeNode, 2));
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return lists;
        }
        List<Integer> arrayList = new ArrayList<>();
        pathSum(root, sum, arrayList);
        return lists;
    }

    public boolean pathSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return true;
        }

        pathSum(root.left, sum - root.val, list);
        pathSum(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
        return false;
    }

}

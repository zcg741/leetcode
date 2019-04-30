package cn.zhangchg.leetcode.tree;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 *
 * @author 张晨刚
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(17);
        MinDepth maxDepth = new MinDepth();
        System.err.println(maxDepth.minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepthLeft = minDepth(root.left);
        int minDepthRight = minDepth(root.right);
        if (minDepthLeft == 0 && minDepthRight == 0) {
            return 1;
        }
        if (minDepthRight == 0) {
            return 1 + minDepthLeft;
        }
        if (minDepthLeft == 0) {
            return 1 + minDepthRight;
        }
        return 1 + Math.min(minDepthLeft, minDepthRight);
    }
}

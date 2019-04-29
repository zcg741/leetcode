package cn.zhangchg.leetcode.tree;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 *
 * @author 张晨刚
 */
public class SameTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        SameTree sameTree = new SameTree();
        System.err.println(sameTree.isSameTree(treeNode, treeNode1));
        System.err.println(sameTree.isSameTree(treeNode, treeNode2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

package cn.zhangchg.leetcode.tree;

/**
 * 100. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author 张晨刚
 */
public class SymmetricTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.err.println(symmetricTree.isSymmetric(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean sameTree = isSameTree(root.left, root.right);
        return sameTree;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}

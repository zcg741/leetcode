package cn.zhangchg.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 *
 * @author 张晨刚
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.err.println(treeNode);
        List<Integer> integers = inorderTraversal.inorderTraversal(treeNode);
        System.err.println(integers);
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        //左中右，左结点没有，在往里存储当前的。
        //Stack<TreeNode> stack = new Stack<>();
        //if (root == null) {
        //    return list;
        //}
        ////不能在这push进root。否则会有两次结果。
        //while (!stack.isEmpty() || root != null) {
        //    //这里不能判断root.left,直接判断root。因为比如执行到最左根节点的左孩子时，会弹出最左根节点，
        //    //下面会把root赋给最左根节点的右子树（null）,此时应该弹出栈顶的元素,所以要判断root是否为空，而不能判断root.left是否为空。
        //    if (root != null) {
        //        stack.push(root);
        //        root = root.left;
        //    } else {
        //        TreeNode node = stack.pop();
        //        list.add(node.val);
        //        root = node.right;
        //    }
        //}
        return list;
    }
}

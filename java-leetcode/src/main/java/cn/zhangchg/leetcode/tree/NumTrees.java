package cn.zhangchg.leetcode.tree;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author 张晨刚
 */
public class NumTrees {

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.err.println(numTrees.numTrees(3));
        System.err.println(numTrees.numTrees(5));
    }

    public int numTrees(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = 0;
            for (int j = 0; j <= i - 1; j++) {
                a[i] += a[j] * a[i - 1 - j];
            }
        }
        return a[n];
    }
}

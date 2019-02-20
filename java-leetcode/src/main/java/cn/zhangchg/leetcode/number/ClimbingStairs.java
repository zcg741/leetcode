package cn.zhangchg.leetcode.number;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * <p>
 * 4  5
 * 5  8
 *
 * @author 张晨刚
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.err.println(climbStairs(3));
        System.err.println(climbStairs(4));
        System.err.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a1 = 1, a2 = 2, flag;
        for (int i = 2; i < n; i++) {
            flag = a1 + a2;
            a1 = a2;
            a2 = flag;
        }
        return a2;
    }


}

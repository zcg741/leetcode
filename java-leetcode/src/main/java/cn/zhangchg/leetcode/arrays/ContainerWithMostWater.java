package cn.zhangchg.leetcode.arrays;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author 张晨刚
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.err.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.err.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0,maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] < maxHeight){
                continue;
            }
            for (int j = height.length - 1; j > i; j--) {
                if (height[i] < height[j]) {
                    maxArea = Math.max(maxArea, height[i] * (j - i));
                } else {
                    maxArea = Math.max(maxArea, height[j] * (j - i));
                }
                maxHeight = maxArea / (j - i);
                if (height[j] >= height[i]) {
                    break;
                }
            }
        }
        return maxArea;
    }

    /**
     * 时间 O(N^2)
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] < height[j]) {
                    maxArea = Math.max(maxArea, height[i] * (j - i));
                } else {
                    maxArea = Math.max(maxArea, height[j] * (j - i));
                }
            }
        }
        return maxArea;
    }
}

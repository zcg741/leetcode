package cn.zhangchg.leetcode.arrays;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author 张晨刚
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        //System.err.println(trap(new int[]{4, 2, 3}));
        //System.err.println(trap(new int[]{4, 4, 4, 7, 1, 0}));
        //System.err.println(trap(new int[]{0, 2, 0}));
        //System.err.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
        //System.err.println(trap(new int[]{4, 9, 4, 5, 3, 2}));
        //System.err.println(trap(new int[]{9, 6, 8, 8, 5, 6, 3}));
        //System.err.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.err.println(trap(new int[]{8, 5, 4, 1, 8, 9, 3, 0, 0}));
    }

    private static int trap(int[] height) {
        int index = 0, end = 1, sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) {
                continue;
            }
            index = i;
            end = index + 1;
            break;
        }
        if (height.length - index <= 2) {
            return 0;
        }
        int maxFlag = 0, flag = 0;
        while (index < height.length - 1) {
            if (height[end] >= height[index]) {
                sum += countTrap(height, index, end, height[index], end);
                index = end;
                end = index + 1;
                maxFlag = 0;
                flag = end;
            } else {
                end++;
                if (end < height.length && maxFlag < height[end]) {
                    maxFlag = height[end];
                    flag = end;
                }
            }
            if (end >= height.length - 1) {
                sum += countTrap(height, index, end, maxFlag > height[index] ? height[index] : maxFlag, flag);
                index = flag;
                end = index + 1;
                maxFlag = 0;
                flag = end;
            }
        }
        sum += countTrap(height, index - 1, height.length - 1, maxFlag, flag);
        return sum;
    }

    private static int countTrap(int[] height, int begin, int end, int minFlag, int flag) {
        int sum = 0;
        for (int i = begin; i < end; i++) {
            if (height[i] < minFlag) {
                sum += minFlag - height[i];
            }
            if (flag == i) {
                break;
            }
        }
        return sum;
    }
}

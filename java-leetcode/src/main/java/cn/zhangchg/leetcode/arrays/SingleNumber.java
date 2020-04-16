package cn.zhangchg.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * <p>
 * 注意：
 * <p>
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * Related Topics 位运算
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] ints = singleNumber.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        // 1 + 2 - 1 + 3 - 2 3，5  2
        // 5+ 2 -3 +1 - 2 3 1  2
        // 2 + 1 - 3 + 2  1  2  5
        System.err.println(Arrays.toString(ints));
    }

    public int[] singleNumber(int[] nums) {
        /**
         有两个数只出现了一次记为 num1、num2 初始化为 0, 其余的数出现了两次,
         我们可以对所有的数进行一次异或操作, 易知这个结果就等于 num1 和 num2
         的异或结果(相同的数异或结果都为 0, 0和任意数异或结果都为那个数).

         那么我可以考虑异或结果的某个非 0 位如最后一个非 0 位, 因为我们知道只
         有当 num1、num2 在该位不一样的时候才会出现异或结果为 1. 所以我们以该
         位是否为 1 对数组进行划分, 只要该位为 1 就和 num1 异或, 只要该位为 0
         就和 num2 异或, 这样最终得到就是只出现过一次的两个数(其他在该位为 1 或
         0 的数必然出现 0/2 次对异或结果无影响)
         **/
        int num1 = 0, num2 = 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit_1 = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit_1 <<= 1;
        }

        for (int num : nums) {
            if ((num & bit_1) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
    public int[] singleNumber2(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int[] flag = new int[2];
        List<Integer> list = new ArrayList<>(nums.length / 2 - 2);
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(Integer.valueOf(num));
            } else {
                list.remove(Integer.valueOf(num));
            }
        }
        flag[0] = list.get(0);
        flag[1] = list.get(1);
        return flag;
    }
}

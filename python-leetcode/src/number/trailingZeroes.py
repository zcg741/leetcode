# 给定一个整数 n，返回 n! 结果尾数中零的数量。
#
# 示例 1:
#
# 输入: 3
# 输出: 0
# 解释: 3! = 6, 尾数中没有零。
#
# 示例 2:
#
# 输入: 5
# 输出: 1
# 解释: 5! = 120, 尾数中有 1 个零.
#
# 说明: 你算法的时间复杂度应为 O(log n) 。
#

class Solution:
    def trailingZeroes(self, n: int) -> int:
        if n == 0: return 0
        i = 0
        while n >= 5:
            i += n // 5
            n //= 5
        return i


s = Solution()
print(s.trailingZeroes(3))
print(s.trailingZeroes(5))
print(s.trailingZeroes(15))
print(s.trailingZeroes(19))
print(s.trailingZeroes(20))
print(s.trailingZeroes(25))
print(s.trailingZeroes(100))

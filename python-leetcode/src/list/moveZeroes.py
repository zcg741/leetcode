# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
# 示例:
#
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
#
# 说明:
#
#
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
#
#
from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        flag = 0
        zeroFlag = 0
        while flag < len(nums):
            if nums[flag] != 0:
                nums[zeroFlag] = nums[flag]
                zeroFlag += 1
            flag += 1
        while zeroFlag < len(nums):
            nums[zeroFlag] = 0
            zeroFlag += 1


s = Solution()
nums = [0, 1, 0, 0, 3, 12]
print(nums)
s.moveZeroes(nums)
print(nums)

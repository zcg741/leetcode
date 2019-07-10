# 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
#
# 示例 1:
#
# 输入: nums = [1,2,3,1], k = 3
# 输出: true
#
# 示例 2:
#
# 输入: nums = [1,0,1,1], k = 1
# 输出: true
#
# 示例 3:
#
# 输入: nums = [1,2,3,1,2,3], k = 2
# 输出: false
#
from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        num = {}
        for i in range(len(nums)):
            if nums[i] in num:
                dist = i - num[nums[i]]
                if dist <= k:
                    return True
                else :
                    num[nums[i]] = i
            else:
                num[nums[i]] = i
        return False


s = Solution()
flag = s.containsNearbyDuplicate([99, 99], 2)
print(flag)
flag = s.containsNearbyDuplicate([99, 99], 3)
print(flag)
flag = s.containsNearbyDuplicate([], 0)
print(flag)
flag = s.containsNearbyDuplicate([1, 2, 3, 1], 3)
print(flag)

flag = s.containsNearbyDuplicate([1, 2, 1, 1], 1)
print(flag)
flag = s.containsNearbyDuplicate([1, 2, 3, 1, 2, 3], 2)
print(flag)

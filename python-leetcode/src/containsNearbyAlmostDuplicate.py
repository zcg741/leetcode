# 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
#
# 示例 1:
#
# 输入: nums = [1,2,3,1], k = 3, t = 0
# 输出: true
#
# 示例 2:
#
# 输入: nums = [1,0,1,1], k = 1, t = 2
# 输出: true
#
# 示例 3:
#
# 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
# 输出: false
#
from typing import List


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        nums_loc = []
        for idx, num in enumerate(nums):
            nums_loc.append([num, idx])
        nums_loc.sort()
        n = len(nums)
        # print(nums_loc)
        for i in range(n):
            for j in range(i + 1, n):
                if nums_loc[j][0] - nums_loc[i][0] > t:
                    break
                if abs(nums_loc[i][1] - nums_loc[j][1]) <= k:
                    return True
        return False


s = Solution()
flag = s.containsNearbyAlmostDuplicate([1, 2, 3, 1], 3, 0)
print(flag)

flag = s.containsNearbyAlmostDuplicate([1, 2, 1, 1], 1, 2)
print(flag)
flag = s.containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], 2, 3)
print(flag)

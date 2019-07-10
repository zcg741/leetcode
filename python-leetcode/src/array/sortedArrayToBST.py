# 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
#
# 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
#
# 示例:
#
# 给定有序数组: [-10,-3,0,5,9],
#
# 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
#
#      0
#     / \
#   -3   9
#   /   /
# -10  5
#
#

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List

from src.TreeNode import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums: return
        mid = len(nums) // 2
        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid + 1:])
        return root

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return self.sortedArrayToBSTNums(nums, 0, len(nums) - 1)

    def sortedArrayToBSTNums(self, nums: List[int], start: int, end: int) -> TreeNode:
        if end < start: return None
        n = end - start
        if n <= 0: return TreeNode(nums[start])
        if n == 1:
            a = TreeNode(nums[end])
            a.left = TreeNode(nums[start])
            return a
        n2 = start + int(n / 2)
        a = TreeNode(nums[n2])
        a.left = self.sortedArrayToBSTNums(nums, start, n2 - 1)
        a.right = self.sortedArrayToBSTNums(nums, n2 + 1, end)
        return a


s = Solution()

flag = s.sortedArrayToBST([0])
print(flag)
flag = s.sortedArrayToBST([3, 5, 8])
print(flag)
flag = s.sortedArrayToBST([-10, -3, 0, 5, 9])
print(flag)

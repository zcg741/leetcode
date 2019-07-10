# 翻转一棵二叉树。
#
# 示例： 
#
# 输入： 
#
#      4
#   /   \
#  2     7
# / \   / \
# 1   3 6   9
#
# 输出： 
#
#      4
#   /   \
#  7     2
# / \   / \
# 9   6 3   1
#
# 备注: 
# 这个问题是受到 Max Howell 的 原问题 启发的 ：
#
# 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
#

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from TreeNode import TreeNode

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if (root == None): return root
        tmpNode = root.left
        root.left = root.right
        root.right = tmpNode
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

s = Solution()
treeNode = TreeNode(4)
leftTreeNode = TreeNode(2)
leftLeftTreeNode = TreeNode(1)
leftRightTreeNode = TreeNode(3)
rightTreeNode = TreeNode(7)
rightLeftTreeNode = TreeNode(6)
rightRightTreeNode1 = TreeNode(9)
leftTreeNode.left = leftLeftTreeNode
leftTreeNode.right = leftRightTreeNode
rightTreeNode.left = rightLeftTreeNode
rightTreeNode.right = rightRightTreeNode1
treeNode.left = leftTreeNode
treeNode.right = rightTreeNode
print(treeNode)
treeNode = s.invertTree(treeNode)
print(treeNode)

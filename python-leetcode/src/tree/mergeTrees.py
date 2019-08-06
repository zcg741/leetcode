# 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
#
# 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
#
# 示例 1:
#
#
# 输入:
#	Tree 1                     Tree 2
#          1                         2
#         / \                       / \
#        3   2                     1   3
#       /                           \   \
#      5                             4   7
# 输出:
# 合并后的树:
#	     3
#	    / \
#	   4   5
#	  / \   \
#	 5   4   7
#
#
# 注意: 合并必须从两个树的根节点开始。
#

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from src.tree.TreeNode import TreeNode


class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if t1 == None:
            return t2
        elif t2 == None:
            return t1
        t3 = TreeNode(t1.val + t2.val)
        t3.right = self.mergeTrees(t1.right, t2.right)
        t3.left = self.mergeTrees(t1.left, t2.left)
        return t3

s = Solution()
treeNode = TreeNode(1)
leftTreeNode = TreeNode(3)
leftRightTreeNode = TreeNode(5)
rightTreeNode = TreeNode(2)
leftTreeNode.left = leftRightTreeNode
treeNode.left = leftTreeNode
treeNode.right = rightTreeNode

treeNode2 = TreeNode(2)
leftTreeNode2 = TreeNode(1)
leftLeftTreeNode2 = TreeNode(4)
rightTreeNode2 = TreeNode(3)
rightRightTreeNode2 = TreeNode(7)
leftTreeNode2.right = leftLeftTreeNode2
rightTreeNode.right = rightRightTreeNode2
treeNode2.left = leftTreeNode2
treeNode2.right = rightTreeNode2
t3 = s.mergeTrees(treeNode,treeNode2)
print(t3)
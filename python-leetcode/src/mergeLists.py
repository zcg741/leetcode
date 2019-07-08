# 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
#
# 示例:
#
# 输入:
# [
#   1->4->5,
#   1->3->4,
#   2->6
# ]
# 输出: 1->1->2->3->4->4->5->6
#

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from src.listNode import ListNode
from typing import List


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) == 0: return None
        if len(lists) == 1: return lists[0]
        if len(lists) == 2:
            if lists[0] == None: return lists[1]
            if lists[1] == None: return lists[0]
            newListNode = ListNode(0)
            leftListNode, rightListNode = lists[0], lists[1]
            tmp = newListNode
            while leftListNode and rightListNode:
                if leftListNode.val <= rightListNode.val:
                    tmp.next = leftListNode
                    leftListNode = leftListNode.next
                else:
                    tmp.next = rightListNode
                    rightListNode = leftListNode
                    leftListNode = tmp.next.next
                tmp = tmp.next
            if not leftListNode:
                tmp.next = rightListNode
            else:
                tmp.next = leftListNode
            return newListNode.next
        i = 0
        tmpList = []
        while i < len(lists) - 1:
            tmpList.append(self.mergeKLists([lists[i], lists[i + 1]]))
            i += 2
        if i == len(lists) - 1:
            tmpList.append(lists[i])
        return self.mergeKLists(tmpList)


s = Solution()
head1 = ListNode(1)
head2 = ListNode(4)
head3 = ListNode(5)
head21 = ListNode(1)
head22 = ListNode(3)
head23 = ListNode(4)
head31 = ListNode(2)
head32 = ListNode(6)
head1.next = head2
head2.next = head3
head21.next = head22
head22.next = head23
head31.next = head32
lists = [head1, head21, head31]
print(lists)
newListNode = s.mergeKLists(lists)
print(newListNode)

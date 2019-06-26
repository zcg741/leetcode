# 删除链表中等于给定值 val 的所有节点。
#
# 示例:
#
# 输入: 1->2->6->3->4->5->6, val = 6
# 输出: 1->2->3->4->5
#
#

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from listNode import ListNode

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        newNode = ListNode(head.val)
        newTmpNode = newNode
        tmpNode = head
        while tmpNode.next != None:
            if tmpNode.val != val:
                newTmpNode.next = ListNode(tmpNode.val)
                newTmpNode = newTmpNode.next
            tmpNode = tmpNode.next
        if tmpNode.val != val:
            if tmpNode.val != val:
                newTmpNode.next = ListNode(tmpNode.val)
                newTmpNode = newTmpNode.next
        if val == newNode.val: return newNode.next
        return newNode.next


s = Solution()
head1 = ListNode(1)
head2 = ListNode(2)
head3 = ListNode(3)
head4 = ListNode(4)
head46 = ListNode(6)
head5 = ListNode(5)
head6 = ListNode(6)
head1.next = head2
head2.next = head3
head3.next = head4
head4.next = head46
head46.next = head5
head5.next = head6
print(head1)
newListNode = s.removeElements(head1, 1)
print(newListNode)

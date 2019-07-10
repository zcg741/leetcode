# 反转一个单链表。
#
# 示例:
#
# 输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL
#
# 进阶:
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
#

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from listNode import ListNode


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        tmpNode = head
        newNode  = None
        while tmpNode != None:
            newFlagListNode = ListNode(tmpNode.val)
            newFlagListNode.next = newNode
            newNode = newFlagListNode
            tmpNode = tmpNode.next
        return newNode


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
newListNode = s.reverseList(head1)
print(newListNode)

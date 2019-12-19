package cn.zhangchg.leetcode.list;

/**
 * 反转链表
 * @author zhangchg
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tmpEnd = new ListNode(head.val);
        ListNode next = head.next;
        ListNode tmpHead = new ListNode(next.val);
        tmpHead.next = tmpEnd;
        tmpEnd = tmpHead;
        while ((next = next.next) != null) {
            tmpHead = new ListNode(next.val);
            tmpHead.next = tmpEnd;
            tmpEnd = tmpHead;
        }
        return tmpHead;
    }
}

package cn.zhangchg.leetcode.list;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author 张晨刚
 */
public class DeleteDuplicates {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(2);
        ListNode l1111 = new ListNode(3);
        ListNode l11111 = new ListNode(3);
        ListNode l111111 = new ListNode(3);
        ListNode l1111111 = new ListNode(4);
        l111111.next = l1111111;
        l11111.next = l111111;
        l1111.next = l11111;
        l111.next = l1111;
        l11.next = l111;
        l1.next = l11;
        System.err.println(l1);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        l1 = deleteDuplicates.deleteDuplicates(l1);
        System.err.println(l1);
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode end = head;
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                    end = node;
                }
                if (pre == null) {
                    head = end;
                    node = head;
                } else {
                    pre.next = end;
                    node = end;
                }
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
}

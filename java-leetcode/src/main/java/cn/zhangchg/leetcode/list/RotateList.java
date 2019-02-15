package cn.zhangchg.leetcode.list;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author 张晨刚
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(3);
        ListNode l1111 = new ListNode(4);
        ListNode l11111 = new ListNode(5);
        //l1111.next = l11111;
        //l111.next = l1111;
        //l11.next = l111;
        l1.next = l11;
        System.err.println(l1);
        ListNode listNode = rotateRight(l1, 2);
        System.err.println(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tmpNode = new ListNode(0);
        tmpNode.next = head;
        int i = 0;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            i++;
        }
        k %= i;
        i = i - k;
        ListNode endNode = new ListNode(0);
        endNode.next = new ListNode(head.val);
        ListNode tmp = endNode.next;
        head = head.next;
        int j = 1;
        while (j < i) {
            tmp.next = new ListNode(head.val);
            tmp = tmp.next;
            head = head.next;
            j++;
        }
        if (head == null) {
            return endNode.next;
        }
        ListNode tmpNode2 = head;
        while (tmpNode2.next != null) {
            tmpNode2 = tmpNode2.next;
        }
        tmpNode2.next = endNode.next;
        return head;
    }

}

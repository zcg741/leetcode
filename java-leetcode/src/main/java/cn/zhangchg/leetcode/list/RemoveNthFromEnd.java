package cn.zhangchg.leetcode.list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author 张晨刚
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(3);
        //ListNode l1111 = new ListNode(4);
        //ListNode l11111 = new ListNode(5);
        //l1111.next = l11111;
        //l111.next = l1111;
        l11.next = l111;
        l1.next = l11;
        System.err.println(l1);
        ListNode listNode = removeNthFromEnd(l1, 1);
        System.err.println(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int maxLength = 1;
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            maxLength++;
            tmpNode = tmpNode.next;
        }
        int tmpN = 1;
        tmpNode = head;
        while (tmpN < (maxLength - n)) {
            tmpNode = tmpNode.next;
            tmpN++;
        }
        if (maxLength == n) {
            return head.next;
        }
        if(n == 1){
            tmpNode.next = null;
        } else {
            tmpNode.next = tmpNode.next.next;
        }
        return head;
    }
}

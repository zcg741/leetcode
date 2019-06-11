package cn.zhangchg.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author zhangchg
 */
public class HasCycle {

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = head;
        head.next = listNode;
        System.err.println(hasCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        while (head != null) {
            // 这是自己走过的路，说明有环
            if (head.val == 18464187) {
                return true;
            }
            head.val = 18464187;
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}

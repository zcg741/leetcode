package cn.zhangchg.leetcode.list;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Related Topics 链表 双指针
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        //listNode.next = listNode2;
        head.next = listNode;
        System.err.println(isPalindrome.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            //反转前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null ? slow.next : slow;
        return equalsList(p1, p2);
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
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
        return tmpHead.equals(head);
    }

    public boolean equalsList(ListNode tmpHead, ListNode head) {
        if (tmpHead.val != head.val) {
            return false;
        }
        ListNode q = tmpHead, p = head;
        while (q.next != null) {
            if (q.next.val != p.next.val) {
                return false;
            }
            q = q.next;
            p = p.next;
        }
        return true;
    }

}

package cn.zhangchg.leetcode.list;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author 张晨刚
 */
public class MergeTwoLists {


    public static void main(String[] args) {
        //[-2,5]
        //[-9,-6,-3,-1,1,6]'\

        ListNode l1 = new ListNode(-2);
        ListNode l11 = new ListNode(5);
        ListNode l111 = new ListNode(4);
        ListNode l1111 = new ListNode(4);/**/
        ListNode l11111 = new ListNode(5);
        //l1111.next = l11111;
        //l111.next = l1111;
        //l11.next = l111;
        l1.next = l11;
        System.err.println(l1);

        ListNode l2 = new ListNode(-9);
        ListNode l21 = new ListNode(-3);
        ListNode l211 = new ListNode(-1);
        ListNode l2111 = new ListNode(1);/**/
        ListNode l21111 = new ListNode(6);
        l2111.next = l21111;
        l211.next = l2111;
        l21.next = l211;
        l2.next = l21;
        System.err.println(l2);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.err.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val > l2.val) {
            listNode = l2;
            l2 = l1;
            l1 = listNode;
        } else {
            listNode = l1;
        }
        listNode.val = l1.val;
        l1 = l1.next;
        if (l1 == null) {
            listNode.next = l2;
            return listNode;
        }
        ListNode tmpNode = listNode;
        while (l2.next != null || l1.next != null) {
            if (l2.val > l1.val) {
                ListNode nextNode = new ListNode(l1.val);
                tmpNode.next = nextNode;
                l1 = l1.next;
                tmpNode = nextNode;
                if (l1 == null) {
                    tmpNode.next = l2;
                    return listNode;
                }
            } else {
                ListNode nextNode = new ListNode(l2.val);
                tmpNode.next = nextNode;
                l2 = l2.next;
                tmpNode = nextNode;
                if (l2 == null) {
                    tmpNode.next = l1;
                    return listNode;
                }
            }
        }

        if (l2.val > l1.val) {
            do {
                if (l2.val >= l1.val) {
                    ListNode nextNode = new ListNode(l1.val);
                    tmpNode.next = nextNode;
                    l1 = l1.next;
                    tmpNode = nextNode;
                    if (l1 == null) {
                        tmpNode.next = l2;
                        return listNode;
                    }
                }
            } while (l1.next != null);
            tmpNode.next = l2;
        } else {
            do {
                if (l2.val <= l1.val) {
                    ListNode nextNode = new ListNode(l2.val);
                    tmpNode.next = nextNode;
                    l2 = l2.next;
                    tmpNode = nextNode;
                    if (l2 == null) {
                        tmpNode.next = l1;
                        return listNode;
                    }
                }
            } while (l2.next != null);
            tmpNode.next = l1;
        }
        return listNode;
    }
}

package cn.zhangchg.leetcode.number;

import cn.zhangchg.leetcode.list.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(8);
        l11.next = new ListNode(3);
        l1.next = l11;
        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(6);
        l21.next = new ListNode(4);
        l2.next = l21;
        ListNode listNode = addTwoNumbers(l1, l2);
        System.err.println(listNode.val + ">" + listNode.next.val + ">" + listNode.next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(0);
        ListNode tempNode = firstNode;
        int flag = 0;
        ListNode nextNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (flag == 0) {
                    tempNode.next = l2;
                    flag = 1;
                    break;
                } else {
                    l1 = new ListNode(0);
                }
            }
            if (l2 == null) {
                if (flag == 0) {
                    tempNode.next = l1;
                    flag = 1;
                    break;
                } else {
                    l2 = new ListNode(0);
                }
            }
            int sum = flag + l1.val + l2.val;
            nextNode = new ListNode(sum % 10);
            nextNode.next = new ListNode(sum / 10);
            flag = sum / 10;
            if (tempNode == null) {
                firstNode.next = nextNode;
            } else {
                tempNode.next = nextNode;
            }
            tempNode = nextNode;
            l2 = l2.next;
            l1 = l1.next;
        }
        if (flag == 0) {
            tempNode.next = null;
        }
        return firstNode.next;
    }
}
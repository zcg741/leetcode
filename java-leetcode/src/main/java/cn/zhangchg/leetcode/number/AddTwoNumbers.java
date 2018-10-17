package cn.zhangchg.leetcode.number;

import java.util.ArrayList;
import java.util.List;

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
        //l11.next = new ListNode(3);
        l1.next = l11;
        ListNode l2 = new ListNode(0);
        //ListNode l21 = new ListNode(6);
        //l21.next = new ListNode(4);
        //l2.next = l21;
        ListNode listNode = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(0);
        ListNode q = l1, p = l2, tempNode = firstNode;
        int flag = 0;
        ListNode nextNode;
        while (q != null || p != null) {
            if (q == null) {
                q = new ListNode(0);
            }
            if (p == null) {
                p = new ListNode(0);
            }
            int sum = flag + q.val + p.val;
            nextNode = new ListNode(sum % 10);
            nextNode.next = new ListNode(sum / 10);
            flag = sum / 10;
            if (l1 == q) {
                firstNode.next = nextNode;
            } else {
                tempNode.next = nextNode;
            }
            tempNode = nextNode;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (flag == 0) {
            tempNode.next = null;
        }
        return firstNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
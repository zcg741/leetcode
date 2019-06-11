package cn.zhangchg.leetcode.list;

import java.util.Objects;

/**
 * listNode
 *
 * @author 张晨刚
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode tmpNode = this;
        StringBuffer sb = new StringBuffer();
        while (tmpNode.next != null) {
            sb.append(tmpNode.val).append("--> ");
            tmpNode = tmpNode.next;
        }
        sb.append(tmpNode.val);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
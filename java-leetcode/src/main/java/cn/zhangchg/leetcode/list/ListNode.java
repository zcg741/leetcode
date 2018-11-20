package cn.zhangchg.leetcode.list;

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
}
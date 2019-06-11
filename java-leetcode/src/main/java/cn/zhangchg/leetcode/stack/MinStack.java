package cn.zhangchg.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * @author zhangchg
 */
public class MinStack {

    public static void main(String[] args) {
        //解答失败: 测试用例:["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
        //测试结果:[null,null,null,null,null,0,null,0,null,0,null,0]
        //期望结果:[null,null,null,null,null,0,null,0,null,0,null,2]
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        System.err.println(obj.getMin());
        obj.pop();
        System.err.println(obj.getMin());
        obj.pop();
        System.err.println(obj.getMin());
        obj.pop();
        System.err.println(obj.getMin());
    }
/*
    private Stack<Integer> stack;

    */
    /**
     * initialize your data structure here.
     *//*
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }*/
    private int start = 0;
    private int end = -1;
    private int size = 0;
    private int[] arr = new int[10];
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
    }

    public void push(int x) {
        arr[++end] = x;
        min = Math.min(x, min);
        size++;
        if (size == arr.length) {
            int[] tmpArr = new int[size * 2];
            System.arraycopy(arr, 0, tmpArr, 0, arr.length);
            arr = tmpArr;
            for (int i = end + 1; i < arr.length; i++) {
                arr[i] = Integer.MAX_VALUE;
            }
        }
    }

    public void pop() {
        int flag = arr[end];
        arr[end--] = Integer.MAX_VALUE;
        if (flag == min) {
            min = Arrays.stream(arr).min().getAsInt();
        }
    }

    public int top() {
        return arr[end];
    }

    public int getMin() {
        return min;
    }
}

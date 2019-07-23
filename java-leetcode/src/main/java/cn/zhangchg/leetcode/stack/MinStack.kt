package cn.zhangchg.leetcode.stack

import java.util.Arrays
import java.util.Stack

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 *
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *
 *
 *
 * 示例:
 *
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * @author zhangchg
 */
class MinStack {
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
    private val start = 0
    private var end = -1
    private var size = 0
    private var arr = IntArray(10)
    var min = Integer.MAX_VALUE
        internal set

    /**
     * initialize your data structure here.
     */
    init {
        for (i in arr.indices) {
            arr[i] = Integer.MAX_VALUE
        }
    }

    fun push(x: Int) {
        arr[++end] = x
        min = Math.min(x, min)
        size++
        if (size == arr.size) {
            val tmpArr = IntArray(size * 2)
            System.arraycopy(arr, 0, tmpArr, 0, arr.size)
            arr = tmpArr
            for (i in end + 1 until arr.size) {
                arr[i] = Integer.MAX_VALUE
            }
        }
    }

    fun pop() {
        val flag = arr[end]
        arr[end--] = Integer.MAX_VALUE
        if (flag == min) {
            min = Arrays.stream(arr).min().asInt
        }
    }

    fun top(): Int {
        return arr[end]
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            //解答失败: 测试用例:["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
            //[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
            //测试结果:[null,null,null,null,null,0,null,0,null,0,null,0]
            //期望结果:[null,null,null,null,null,0,null,0,null,0,null,2]
            val obj = MinStack()
            obj.push(2)
            obj.push(0)
            obj.push(3)
            obj.push(0)
            System.err.println(obj.min)
            obj.pop()
            System.err.println(obj.min)
            obj.pop()
            System.err.println(obj.min)
            obj.pop()
            System.err.println(obj.min)
        }
    }
}

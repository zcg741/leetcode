package cn.zhangchg.leetcode.stack

import java.util.*

/**
 * 使用栈实现队列的下列操作：
 *
 *
 *
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 *
 *
 *
 * 示例:
 *
 *
 * MyQueue queue = new MyQueue();
 *
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  返回 1
 * queue.pop();   返回 1
 * queue.empty(); 返回 false
 *
 *
 * 说明:
 *
 *
 *
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 *
 * Related Topics 栈 设计
 * @author zhangchg
 */
class MyQueue {

    private val stack: Stack<Int>
    private val stackTmp: Stack<Int>

    /**
     * Initialize your data structure here.
     */
    init {
        stack = Stack()
        stackTmp = Stack()
    }

    /**
     * Push element x to the back of queue.
     */
    fun push(x: Int) {
        while (!stack.empty()) {
            stackTmp.push(stack.pop())
        }
        stack.push(x)
        while (!stackTmp.empty()) {
            stack.push(stackTmp.pop())
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    fun pop(): Int {
        return stack.pop()
    }

    /**
     * Get the front element.
     */
    fun peek(): Int {
        return stack.peek()
    }

    /**
     * Returns whether the queue is empty.
     */
    fun empty(): Boolean {
        return stack.empty()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val myQueue = MyQueue()
            myQueue.push(1)
            myQueue.push(2)
            val param_2 = myQueue.pop()
            System.err.println(param_2)
            var param_3 = myQueue.peek()
            System.err.println(param_3)
            var param_4 = myQueue.empty()
            System.err.println(param_4)
            param_3 = myQueue.pop()
            System.err.println(param_3)
            param_4 = myQueue.empty()
            System.err.println(param_4)
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
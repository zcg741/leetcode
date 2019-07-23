package cn.zhangchg.leetcode.stack

import java.util.*
import java.util.concurrent.ArrayBlockingQueue

//使用队列实现栈的下列操作：
//
//
// push(x) -- 元素 x 入栈
// pop() -- 移除栈顶元素
// top() -- 获取栈顶元素
// empty() -- 返回栈是否为空
//
//
// 注意:
//
//
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
//
//

class MyStack() {

    /** Initialize your data structure here. */

    var list = ArrayDeque<Int>()
    private var last = -1
//    var listRight = ArrayDeque<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        last = x
        list.offer(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        val tmpList = ArrayDeque<Int>()
        last = -1
        while (list.size > 1) {
            if (list.size == 2) {
                last = list.peek()
            }
            tmpList.offer(list.pop())
        }
        val first = list.pop()
        list = tmpList
        return first
    }

    /** Get the top element. */
    fun top(): Int {
        return last
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return list.size == 0
    }

    /** Initialize your data structure here. *//*

    var list = LinkedList<Int>()
//    var listRight = ArrayDeque<Int>()

    */
    /** Push element x onto stack. *//*

    fun push(x: Int) {
        list.addFirst(x)
    }

    */
    /** Removes the element on top of the stack and returns that element. *//*

    fun pop(): Int {
        if(list.size == 0){
            return -1
        }
        val first = list.first
        list.removeFirst()
        return first
    }

    */
    /** Get the top element. *//*

    fun top(): Int {
        return list.first
    }

    */
    /** Returns whether the stack is empty. *//*

    fun empty(): Boolean {
        return list.size == 0
    }
*/

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var obj = MyStack()
            obj.push(1)
            obj.push(2)
            var param_2 = obj.top()
            println(param_2)
            var param_3 = obj.pop()
            println(param_3)
            var param_4 = obj.empty()
            println(param_4)
        }
    }
}

/**
 * 解答失败:
 * 测试用例:["MyStack","push","pop","empty"] [[],[1],[],[]]
 * 测试结果:[null,null,1,false] 期望结果:[null,null,1,true]
 * 运行成功: 测试用例:
 * ["MyStack","push","push","top","pop","empty"]
 * [[],[1],[2],[],[],[]]
 * 测试结果:[null,null,null,2,2,true]
 * 期望结果:[null,null,null,2,2,false]
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
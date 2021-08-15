package org.bobo.datastructure.queue;

import org.bobo.datastructure.stack.Stack;

/**
 * @author LY
 * @date 2021/07/21 05:39
 * <p>
 * Description:
 * 循环队列 避免频繁数据移动带来的消耗
 * 自己实现版本
 *
 */
public class LoopQueueV1<E> implements Queue<E> {

    /**
     * 底层数据存放
     */
    private E[] data;

    /**
     * 指向队列头
     */
    private int front;

    /**
     * 指向队列尾
     * 初始化是front = tail = 0
     * 其他状态下，tail不能与tail重合
     *
     */
    private int tail;

    /**
     * 栈的大小
     */
    private int size;

    /**
     * 构造方法
     * 初始化内部数组数据结构
     *
     * @param capacity
     */
    public LoopQueueV1(int capacity) {
        // 循环队列为何需要浪费一个格子
        // 为了区分队列满或者是空的条件
        // 队列为空 front == tail
        // 队列为满
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }


    /**
     * 读取栈的大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail && size == 0;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 判断队列是否满
        if (size == data.length) {
            // 扩容为原来的两倍
            resize(data.length * 2);
        }

        // 如果有 压入队列
        data[this.tail] = e;
        int newTail = loopNext(this.tail);
        if (newTail != this.front) {
            this.tail = newTail;
        }
        size++;
    }

    /**
     * 复制扩容data
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        if (newCapacity < data.length) {
            throw new RuntimeException("newCapacity must bigger than the original capacity");
        }
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;

    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        size--;
        int newFront = loopNext(this.front);
        // 取出队列最前面的一个元素
        this.front = newFront;
        return data[newFront];
    }

    /**
     * 获取队首的元素
     *
     * @return
     */
    @Override
    public E getFront() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        // 读取队列最前面的一个元素
        return data[front];
    }

    /**
     * 自己的循环实现
     * 维护front/tail只在底层数组的范围内循环
     *
     * 用的是直观思路实现（比较暴力的解法），让front和tail循环起来
     * 不是最佳的解法 用一个去余的操作就可以实现
     * 面对更加复杂的问题可能就存在问题
     *
     *
     * @param index
     * @return
     */
    private int loopNext(int index) {
        // 到数组末端回到数组头部
        if (index == data.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
//        return (index + 1) % data.length;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ").append("front ").append('[');
        int index = front;
        while (index != tail) {
            res.append(data[index]);
            if (loopNext(index) != tail) {
                res.append(", ");
            }
            index = loopNext(index);
        }
        res.append("] tail");
        return res.toString();
    }
}

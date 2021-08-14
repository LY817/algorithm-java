package org.bobo.datastructure.queue;

import org.bobo.datastructure.stack.Stack;

/**
 * @author LY
 * @date 2021/07/21 05:39
 * <p>
 * Description:
 * 循环队列 避免频繁数据移动带来的消耗
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 底层数据存放
     */
    private E[] data;

    /**
     * 指向队列头
     */
    private int head;

    /**
     * 指向队列尾
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
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        head = 0;
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
        return head == tail && size == 0;
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
            throw new RuntimeException("the queue is full");
        }

        // 如果有 压入队列
        data[this.tail] = e;
        int newTail = loopNext(this.tail);
        if (newTail != this.head) {
            this.tail = newTail;
        }
        size++;
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
        int newHead = loopNext(this.head);
        // 取出队列最前面的一个元素
        this.head = newHead;
        return data[newHead];
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
        return data[head];
    }


    private int loopNext(int index) {
        // 到数组末端回到数组头部
        if (index == data.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ").append("front ").append('[');
        int index = head;
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

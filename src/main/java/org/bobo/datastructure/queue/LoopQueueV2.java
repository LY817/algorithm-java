package org.bobo.datastructure.queue;

/**
 * @author LY
 * @date 2021/08/15 09:36
 * <p>
 * Description:
 * 用取余实现循环队列
 */
public class LoopQueueV2<E> implements Queue<E> {

    /**
     * 底层数据
     */
    private E[] data;

    /**
     * 虚拟的offset 不是真正的数组index
     */
    private int front;

    /**
     * 虚拟的offset 不是真正的数组index
     */
    private int tail;

    private int capacity;

    public LoopQueueV2(int capacity) {
        data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.capacity = capacity;
    }

    @Override
    public int getSize() {
        return tail - front;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 当tail+1与front重合 代表队列满了
        if ((tail + 1) % data.length == front % data.length) {
            resize(capacity * 2);
        }
        data[tail] = e;
        tail++;
    }

    /**
     * 从front开始复制到新队列的头部
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        if (newCapacity < tail - front) {
            throw new RuntimeException("the resize capacity is too small");
        }
        capacity = newCapacity;
        E[] newData = (E[]) new Object[capacity + 1];
        int newDataIndex = 0;
        for (int i = front; i < tail;i++) {
            newData[newDataIndex] = data[front % data.length];
            newDataIndex++;
        }
        data = newData;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        E ret = data[front++ % (capacity + 1)];
        return ret;
    }

    /**
     * 获取队首的元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return data[front % data.length];
    }

    private int loopNext(int index) {
        // 到数组末端回到数组头部
        return (index + 1) % data.length;
    }

        @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ").append("front ").append('[');
        for (int i = front; i < tail; i++) {
            res.append(data[i % (capacity + 1)]);
            if (i < tail - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
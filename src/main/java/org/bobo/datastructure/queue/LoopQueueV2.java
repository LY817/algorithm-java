package org.bobo.datastructure.queue;

/**
 * @author LY
 * @date 2021/08/15 09:36
 * <p>
 * Description:
 * 用取余实现循环队列
 */
public class LoopQueueV2<E> implements Queue<E> {
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        return null;
    }

    /**
     * 获取队首的元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return null;
    }
}

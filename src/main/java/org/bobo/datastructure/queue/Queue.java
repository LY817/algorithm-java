package org.bobo.datastructure.queue;

/**
 * Created by LuoYu on 2021/7/11.
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首的元素
     * @return
     */
    E getFront();
}

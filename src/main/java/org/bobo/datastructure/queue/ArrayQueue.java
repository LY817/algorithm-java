package org.bobo.datastructure.queue;

import org.bobo.datastructure.Array;

/**
 * @author LY
 * @date 2021/07/11 20:43
 * <p>
 * Description:
 */
public class ArrayQueue<E> implements Queue<E> {

   private Array<E> array;

   public ArrayQueue(int capacity) {
       array = new Array<>(capacity);
   }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
       return array.getCapacity();
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     * 直接使用array来实现出队
     * 时间复杂度为O(n)
     * 因为每出一次队，就需要进行复杂度为O(n)一次数据移动
     * 使用循环队列:用两个指针来维护整个队列 指向头尾
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 读取取队首的元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ").append("front ").append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

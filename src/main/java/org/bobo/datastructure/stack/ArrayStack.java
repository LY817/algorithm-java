package org.bobo.datastructure.stack;

import org.bobo.datastructure.Array;

/**
 * @author LY
 * @date 2021/07/11 09:49
 * <p>
 * Description:
 * 数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    /**
     * 压栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 取出栈顶的一个元素
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 读取栈的大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ").append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}

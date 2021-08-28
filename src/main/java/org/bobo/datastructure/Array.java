package org.bobo.datastructure;

import java.util.List;

/**
 * @author LY
 * @date 2021/07/05 06:27
 * <p>
 * Description:
 * 数组实现
 */
public class Array<E> {

    /**
     * 底层数据存放
     */
    private E[] data;

    /**
     * 维护数组
     * 指向第一个没有元素的data
     */
    private int size;



    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 向指定位置插入一个新元素e
     * 从后向前
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        // 方法的开头 做验证 是一个好习惯
        if (size == data.length) {
            throw new IllegalArgumentException("addLast failed: this array is full.");
        }

        if (index > data.length) {
            throw new IllegalArgumentException("the index is out of bound.");
        }

        // 不允许越界操作，对导致不连续
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("the index can not less than zero");
        }

        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = e;
        size++;
    }

    /**
     * 向数组的最后添加一个元素
     *
     * @param e
     */
    public void addLast(E e) throws IllegalArgumentException {
        // 方法复用 也是个好习惯
        add(size, e);
    }

    public void addFirst(E e) throws IllegalArgumentException {
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size --;
        // 手动清空无用的对象引用
        // 这种对象称为loitering objects
        // loitering objects != memory leak
        data[size] = null;
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

}

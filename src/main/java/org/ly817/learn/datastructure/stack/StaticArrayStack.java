package org.ly817.learn.datastructure.stack;

/**
 * @author LY
 * @date 2021/03/09 21:38
 * <p>
 * Description:
 * 固定长度的数组栈
 */
public class StaticArrayStack implements Stack {

    /**
     * 存放元素的数据结构
     */
    private String[] items;

    /**
     * 栈的最大深度
     */
    private int size;

    /**
     * 栈中当前的元素个数
     */
    private int count;



    public StaticArrayStack(int size) {
        this.items = new String[size];
        this.count = 0;
        this.size = size;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        if (count == size) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        String result = items[count - 1];
        count--;
        return result;
    }
}

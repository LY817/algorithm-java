package org.ly817.learn.datastructure.queue;

/**
 * @author LY
 * @date 2021/03/09 22:02
 * <p>
 * Description:
 */
public class ArrayQueue implements Queue {
    private String[] items;
    private int size;
    // 保存当前的(入队和出队)进度
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int size) {
        items = new String[size];
        this.size = size;
    }


    /**
     * 向队列尾部加入一个元素
     *
     * @param item
     * @return
     */
    @Override
    public boolean enqueue(String item) {
        // 队列到了数组的尾部
        if (tail == size) {
            if (head == 0) {
                // 队列满
                return false;
            }
            System.out.println("触发搬迁");
            // 还有空位 整体想做搬移
            for (int i = 0; i < tail - head; i++) {
                items[i] = items[i + head];
            }
            // 重新赋值
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 从队列头部取出一个元素
     *
     * @return
     */
    @Override
    public String dequeue() {
        if (head == tail) {
            // 队列为空
            return null;
        }
        String result = items[head];
        head++;
        return result;
    }
}

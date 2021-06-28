package org.ly817.learn.datastructure.queue;

/**
 * Created by LuoYu on 2021-03-09.
 */
public interface Queue {
    /**
     * 向队伍尾部加入一个元素
     * @param item
     * @return
     */
    boolean enqueue(String item);

    /**
     * 从队伍头部取出一个元素
     * @return
     */
    String dequeue();

}

package org.ly817.learn.datastructure.stack;

/**
 * Created by LuoYu on 2021-03-09.
 */
public interface Stack {
    /**
     * 入栈操作
     * @param item
     * @return
     */
    boolean push(String item);

    /**
     * 出栈操作
     * @return
     */
    String pop();
}

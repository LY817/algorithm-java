package org.bobo.datastructure.stack;

/**
 * @author LY
 * @date 2021/07/11 09:43
 * <p>
 * Description:
 * 栈 接口定义
 */
public interface Stack<E> {
    /**
     * 压栈
     * @param e
     */
    public void push(E e);

    /**
     * 取出栈顶的一个元素
     * @return
     */
    public E pop() ;

    /**
     * 查看栈顶元素
     * @return
     */
    public E peek() ;

    /**
     * 读取栈的大小
     * @return
     */
    public int getSize() ;

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() ;
}

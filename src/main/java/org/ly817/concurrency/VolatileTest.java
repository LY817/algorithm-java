package org.ly817.concurrency;

/**
 * @author LY
 * @date 2021/08/28 14:12
 * <p>
 * Description:
 */
public class VolatileTest {
    static  int i = 0;
    static boolean tag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (tag) {
                i++;
            }
        },"t1").start();
        Thread.sleep(100);
        new Thread(() -> {
            // 检验tag的修改能否被t1读到
            tag = false;
            // 检查能否读到t1是否读到t2的改变
            while (true) {
                System.out.println(i);
            }
        },"t2").start();
    }
}


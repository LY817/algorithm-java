package org.ly817.jvm.sync;

/**
 * @author LY
 * @date 2021/08/05 21:06
 * <p>
 * Description:
 * 测试全局锁和对象锁
 * 结论 全局锁和实例锁 相互独立
 */
public class TestSyncLock {
    public static synchronized void doSomething() {
        try {
            Thread.sleep(1000);
            System.out.println("全局锁:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void  doSomethingElse() {
        System.out.println("对象锁");
    }

    public static void main(String[] args) {
        TestSyncLock lock = new TestSyncLock();
        Thread t1 = new Thread(() -> {
            TestSyncLock.doSomething();
        });

        Thread t2 = new Thread(() -> {
//            lock.doSomethingElse();
            TestSyncLock.doSomething();
        });

        t1.start();
        t2.start();

    }
}

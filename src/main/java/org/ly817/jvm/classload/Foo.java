package org.ly817.jvm.classload;

/**
 * @author LY
 * @date 2021/08/22 22:35
 * <p>
 * Description:
 * 类加载特性测试测试
 */
public class Foo {

    private int tryBlock;

    private int catchBlock;

    private int finallyBlock;

    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}

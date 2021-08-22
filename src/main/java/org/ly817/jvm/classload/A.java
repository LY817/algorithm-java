package org.ly817.jvm.classload;

import org.ly817.jvm.invoke.Deer;

/**
 * @author LY
 * @date 2021/08/22 08:42
 * <p>
 * Description:
 * 类加载过程
 * 1. 以类为单位的编译
 */
public class A {
    private B b = new B();

    public static void main(String[] args) {
        A a = new A();
        long num = 65432;
        long test = a.b.test(num);
        System.out.println(test);
    }
}

class B {
    private int a = 23456;

    public long test(long num) {
        return this.a + num;
    }
}

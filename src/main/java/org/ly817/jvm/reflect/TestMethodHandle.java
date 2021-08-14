package org.ly817.jvm.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @author LY
 * @date 2021/08/05 08:04
 * <p>
 * Description:
 * 测试方法句柄
 */
public class TestMethodHandle {
    private static void bar(Object o) {
        new Exception().printStackTrace();
        System.out.println(o);
    }
    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws Throwable {
        // 获取方法句柄的不同方式
        // 1、通过反射的method来获取
        MethodHandles.Lookup l = TestMethodHandle.lookup(); // 具备 Foo 类的访问权限
        Method m = TestMethodHandle.class.getDeclaredMethod("bar", Object.class);
        MethodHandle mh0 = l.unreflect(m);
        mh0.invoke("反射获取");
//        mh0.invokeExact((Object) "反射获取");

        // 2、通过MethodType来获取 入参和出参唯一确认
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh1 = l.findStatic(TestMethodHandle.class, "bar", t);
        mh1.invoke("MethodType来获取");
    }
}

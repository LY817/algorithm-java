package org.ly817.jvm.reflect;

import java.lang.reflect.Method;

/**
 * @author LY
 * @date 2021/08/04 11:13
 * <p>
 * Description:
 * 反射动态生成字节码逻辑
 */
public class TestMethodAccessorGenerator {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("org.ly817.jvm.reflect.TestMethodAccessorGenerator");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }

    }
}

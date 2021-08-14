package org.ly817.jvm.invoke;
import java.lang.invoke.*;
/**
 * @author LY
 * @date 2021/08/08 15:03
 * <p>
 * Description:
 */
public class Circuit {
    public static void startRace(Object obj) {
        // 使用ASM修改改方法的字节码
        // aload obj
        // 使用invokedynamic调用对象的obj方法
        // 注意这里不需要强转也没有使用反射
        // 这个race()是方法句柄MethodHandle
        // invokedynamic race()
    }

    public static void main(String[] args) {
        startRace(new Horse());
        // startRace(new Deer());
    }

    /**
     * 启动方法
     * 将接收前面提到的三个固定参数， 并且返回一个链接至 Horse.race 方法的 ConstantCallSite。
     * @param l
     * @param name
     * @param callSiteType
     * @return
     * @throws Throwable
     */
    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType callSiteType) throws Throwable {
        MethodHandle mh = l.findVirtual(Horse.class, name, MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(callSiteType));
    }
}

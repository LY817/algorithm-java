package org.bobo.search.linearsearch;

/**
 * @author LY
 * @date 2021/06/29 06:28
 * <p>
 * Description:
 * 课程2-3
 * for 循环遍历查询
 * 使用泛型
 */
public class LinearSearchV2 {
    // 阻止外部创建对象
    private LinearSearchV2() {
    }

    /**
     * 泛型方法
     * 泛型不能使用基本数据类型，需要使用包装类
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            // 面向接口 调用泛型类的equals方法实现
            if (data[i].equals(target))
                return i;
        }
        return -1;
    }

    /**
     * 内部测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] data = {13, 455, 34, 5, 6, 45, 6457, 535, 3};
        search(data, 1);
        search(data, 222);
    }
}

package org.bobo.test;

/**
 * @author LY
 * @date 2021/07/01 06:35
 * <p>
 * Description:
 * 数组生成器 用于测试
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}

package org.bobo;

import java.util.Random;

/**
 * @author LY
 * @date 2021/07/03 06:27
 * <p>
 * Description:
 * 通用方法
 */
public class Utils {

    /**
     *
     * @param size
     * @return
     */
    public static Integer[] generateOrderedIntArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 100以内范围的随机数
     * @param size
     * @return
     */
    public static Integer[] generateRandomIntArray(int size) {
        Random ra =new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ra.nextInt(100) + 1;
        }
        return arr;
    }

    /**
     * 交换数组位置
     * @param a 数组索引a
     * @param b 数组索引b
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void swap(int a, int b, E[] arr) {
        E temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static <E> void printArr(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].toString());
            System.out.print(" ");
        }
        System.out.println("\n>>>");
    }
}

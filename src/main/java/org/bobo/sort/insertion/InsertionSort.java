package org.bobo.sort.insertion;

import org.bobo.Utils;

/**
 * @author LY
 * @date 2021/07/03 08:36
 * <p>
 * Description:
 * 插入排序
 */
public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 插入排序基本实现
     *
     * java中 break只会跳出当前循环
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortV0(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 待插入的元素
            // 被插入的集合 arr[0,a)
            // 实际上是对新组成的arr[0,a] 进行一次冒泡排序
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    Utils.swap(j, j - 1, arr);
                } else break;
            }
        }
    }

    /**
     * 优化1
     * 提取循环不变量到for循环控制语句
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortV1(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 内部循环能接续的条件都提取到for循环的控制语句中
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                Utils.swap(j, j - 1, arr);
            }
        }
    }

    /**
     * 通用的swap方法实现插入
     * 会多次比较+交换位置 知道找到合适的位置
     * 会有多次的内存读写
     *
     * 只用写缓存一次 不需要每次swap
     *
     * 可以优化为只比较不交换，直到找到位置后，一次性的批量平移后面的元素
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortV2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 待插入元素
            E temp = arr[i];
            //  待插入位置target
            int target = i;
            //  往回遍历 确认待插入的位置
            for (int j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                target --;
            }
            // 移动数组 [target,i-1] -> [target,i]
            // 循环的方向与移动的方向相反 需要反向遍历
            for (int j = i - 1; j >= target; j--) {
                arr[j + 1] = arr[j];
            }
            arr[target] = temp;
        }
    }

    /**
     * 优化 把两个循环和多余的变量赋值合并到for循环中
     *
     * 没有熟练掌握for循环的各个元素的含义
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortV3(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 待插入元素
            E temp = arr[i];
            //  待插入位置target 作为for循环的初始值
            int target;
            for (target = i;target > 0 && temp.compareTo(arr[target - 1]) < 0; target-- ) {
                arr[target] = arr[target - 1];
            }
            arr[target] = temp;
        }
    }



}

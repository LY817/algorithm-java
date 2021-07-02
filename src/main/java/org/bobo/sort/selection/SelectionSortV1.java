package org.bobo.sort.selection;

import java.lang.reflect.Array;

/**
 * @author LY
 * @date 2021/07/02 05:43
 * <p>
 * Description:
 * 使用额外内存的选择排序
 * 没有确定
 */
public class SelectionSortV1 {

    private SelectionSortV1() {
    }

    /**
     * 找出最小值 依次放到新的数组中
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        int[] another = new int[arr.length];
        for (int i = 0; i < another.length; i++) {
            // 每次循环取最小的
            int min = arr[0];
            for (int j = 0; j < arr.length; j++) {
                // 定义没有界定清楚，把问题规模缩小 只考虑一个问题
                // 子循环中需要得到的最小值
                // 边界条件控制
                if (i == 0) {
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                } else {
                    if (arr[j] > another[i - 1] && arr[j] < min) {
                        min = arr[j];
                    }
                }
            }
            another[i] = min;
        }
        return another;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1231, 313, 133, 222, 3, 45, 6, 6};
        int[] another = sort(arr);
        for (int i = 0; i < another.length; i++) {
            System.out.println(another[i]);
        }
    }
}

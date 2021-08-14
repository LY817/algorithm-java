package org.bobo.sort.selection;

/**
 * @author LY
 * @date 2021/07/02 06:33
 * <p>
 * Description:
 * 原地排序
 */
public class SelectionSortV2 {
    private SelectionSortV2() {

    }

    private static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 子循环（i,arr.length）中最小值index，初始为i
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, arr);
        }
    }

    private static <E extends Comparable<E>> void swap(int i, int minIndex, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

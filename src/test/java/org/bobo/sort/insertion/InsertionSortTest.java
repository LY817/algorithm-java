package org.bobo.sort.insertion;

import org.bobo.Utils;
import org.junit.Test;

/**
 * Created by LuoYu on 2021/7/3.
 */
public class InsertionSortTest {

    @Test
    public void sort() {
//        Integer[] arr = Utils.generateRandomIntArray(10);
        Integer[] arr = new Integer[] {3,2,1};
        Utils.printArr(arr);
        InsertionSort.sortV3(arr);
        Utils.printArr(arr);
    }
}
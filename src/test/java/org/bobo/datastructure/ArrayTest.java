package org.bobo.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/7/5.
 */
public class ArrayTest {

    @Test
    public void addLast() {
    }

    @Test
    public void add() throws IllegalAccessException {
        Array arr = new Array(10);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.add(5,2);
        System.out.println(arr);
    }
}
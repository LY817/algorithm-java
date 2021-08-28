package org.bobo.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/8/28.
 */
public class LinkedListTest {
    @Test
    public void add() throws IllegalAccessException {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);
    }

}
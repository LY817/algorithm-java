package org.bobo.datastructure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/7/11.
 */
public class ArrayStackTest {
    @Test
    public void basic() {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
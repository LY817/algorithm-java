package org.ly817.learn.datastructure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021-03-09.
 */
public class ArrayQueueTest {

    @Test
    public void basicTest() {
        Queue queue = new ArrayQueue(4);
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("1"));
    }

    @Test
    public void MoveTest() {
        Queue queue = new ArrayQueue(4);
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("2"));
        System.out.println(queue.enqueue("3"));
        System.out.println(queue.enqueue("4"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("5"));
    }
}
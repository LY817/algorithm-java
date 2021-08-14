package org.bobo.datastructure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LuoYu on 2021/8/14.
 */
public class LoopQueueTest {
    @Test
    public void basic() {
        Queue<Integer> queue = new LoopQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        System.out.println(queue);

    }
}
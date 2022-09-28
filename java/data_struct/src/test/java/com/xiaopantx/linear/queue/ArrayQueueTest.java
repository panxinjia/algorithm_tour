package com.xiaopantx.linear.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayQueue<>(10);
        for (int i  = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.deQueue();
                System.out.println(queue);
            }
        }

    }

}
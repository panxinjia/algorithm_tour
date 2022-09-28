package com.xiaopantx.linear.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopQueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new LoopQueue<>(10);
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
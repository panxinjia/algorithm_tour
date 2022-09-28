package com.xiaopantx.linear.queue;

import org.junit.jupiter.api.Test;

/**
 * 数组队列 和 循环队列性能测试
 *
 * @author xiaopantx
 */
public class PerformanceTest {

    // 队列入队出队 n 次, 消耗时间
    public static void testQueue(Queue<Integer> queue, int n) {
        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            queue.enQueue(i);
        }

        for (int i = 0; i < n; i++) {
            queue.deQueue();
        }

        long endTime = System.nanoTime();
        double costTime = (endTime - startTime) / 1000000000.0;
        System.out.println(queue.getClass().getSimpleName() + " " + n + " 次操作耗时: " + costTime + " s");
    }

    @Test
    public void test() {
        // 测试循环队列和数组队列的性能
        int[] size = {5_0000, 10_0000};
        for(int n: size) {
            testQueue(new ArrayQueue<>(), n);
            testQueue(new LoopQueue<>(), n);
        }
    }
}

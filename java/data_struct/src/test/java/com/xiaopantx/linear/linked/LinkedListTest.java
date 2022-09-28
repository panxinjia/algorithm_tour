package com.xiaopantx.linear.linked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        System.out.println(list);

        list.add(1,200);
        System.out.println(list);
    }

}
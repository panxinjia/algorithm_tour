package com.xiaopantx.linear;

import com.xiaopantx.linear.stack.ArrayStack;
import com.xiaopantx.linear.stack.Stack;
import org.junit.jupiter.api.Test;

class ArrayStackTest {


    @Test
    public void test() {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack);

    }
}
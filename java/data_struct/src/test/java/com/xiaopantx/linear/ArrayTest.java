package com.xiaopantx.linear;


import com.xiaopantx.linear.array.Array;
import org.junit.jupiter.api.Test;

class ArrayTest {

    @Test
    public void test() {
        Array<Integer> arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        arr.remove(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        arr.addLast(1);
        System.out.println(arr);
        arr.removeAllElements(1);
        arr.removeElement(9);
        System.out.println(arr);

        arr.set(3, 30);
        System.out.println(arr);

        // [-1, 100, 2, 30, 4, 5, 6, 7, 8]


        // 扩容
        for (int i = 0; i < 12; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        // 缩容
        for (int i = 0; i < 20; i++) {
            arr.removeLast();
        }
        System.out.println(arr);

        arr.addLast(20);
        arr.addLast(4);
        System.out.println(arr);


    }

}
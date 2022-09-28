package com.xiaopantx.search;

import java.util.Objects;

/**
 * @author xiaopantx
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // 是否是同一个对象
        if (this == o) return true;
        // 特殊条件
        if (o == null || getClass() != o.getClass()) return false;

        // 向下转型
        Student student = (Student) o;

        // 忽略大小写比较逻辑
        return name != null ? name.equalsIgnoreCase(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

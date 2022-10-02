package com.xiaopantx.sort;

import javafx.scene.control.TableColumn;

/**
 * @author m1513
 */
public enum SortType {
    SELECTION_SORT("选择排序"),
    INSERTION_SORT("插入排序"), INSERTION_SORT_V2("插入排序_V2"), INSERTION_SORT_V3("插入排序_V3"),

    BUBBLE_SORT("冒泡排序"),

    MERGE_SORT("归并排序"),

    QUICK_SORT("快速排序"), QUICK_SORT_V1("随机化快排"), QUICK_SORT_V2("双路快排"), QUICK_SORT_V3("三路快排");

    private String name;

    private SortType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

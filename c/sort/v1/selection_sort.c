#include <stdio.h>
// #include "../../common/swap.h"

// int 类型交换函数
void Swap(int * ip1, int * ip2) {
    int temp = *ip1;
    *ip1 = *ip2;
    *ip2 = temp;
}

// TODO 选择排序
void SelectionSort(int data[], int len) {
    if (data == NULL || len < 2) {
        return;
    }

    for (int i = 0; i < len; i++) {
        int minIdx = i;
        for (int j = i + 1; j < len; j++) {
            if (data[j] < data[minIdx]) {
                minIdx = j;
            }
        }
        // Swap(data + i, data + minIdx, sizeof(int));
        Swap(data + i, data + minIdx);
    }
}

int main(int argc, const char * argv[]) {
    int data[10] = {1, 3, 2, 4, 5, 9, 7, 4, 0, 4};
    SelectionSort(data, 10);

  
    return 0; 
}
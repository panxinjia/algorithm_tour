#include <stdio.h>
// #include "../../common/swap.h"

void Swap(int * data, int m, int n) {
    int temp = *(data + m);
    *(data + m) = *(data + n);
    *(data + n) = temp;
}

// 选择排序
void SelectionSort(int data[], int len) {
    if (data || len < 2) {
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
        Swap(data, i, minIdx);
    }

    // 输出结果
    for (int i = 0; i < len; i++) {
        printf("data[%d] = %d\n", i, data[i]);
    }
}

int main(int argc, const char * argv[]) {
    int data[10] = {1, 3, 2, 4, 5, 9, 7, 4, 0, 4};
    SelectionSort(data, 10);
  
    return 0; 
}
#include <stdio.h>

// 二分查找
// 非递归写法
int BSearch(int key, int data[], int len) {
    int l = 0;
    int r = len - 1;

    while (l <= r) {
        int mid = (r + l) / 2;
        if (data[mid] < key) {
            l = mid + 1;
        }else if (data[mid] > key) {
            r = mid - 1;
        }else {
            // 找到元素
            return mid;
        }
    }
    return -1;
}

// 递归写法
int BSearchR(int key, int data[], int l, int r) {
    int mid = (l + r) / 2;
    if (data[mid] == key) {
        return mid;
    }else if (data[mid] > key) {
        return BSearchR(key, data, l, mid - 1);
    }else if (data[mid] < key){
        return BSearchR(key, data, mid + 1, r);
    }
    return -1;
}

int main(int argc, const char * argv[]) {
    int len = 10;
    int data[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int key = 10;
    int index = BSearchR(key, data, 0, len);
    printf("index = %d\n", index); 

    return 0;
}
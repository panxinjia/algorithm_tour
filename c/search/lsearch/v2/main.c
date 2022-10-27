#include <stdio.h>
#include <string.h>

/**
 * 如果不考虑比较的数据是包含指针的结构, 这个线性搜索函数已经可以正常运行了
 * 
 */
void * LSearch(void * key, void * base, int len, int elemSize) {
    for (int i = 0; i < len; i++) {
        // 计算基地址的技巧
        char * addr = (char *)base + (i * elemSize);
        if (memcmp(key, addr, elemSize) == 0) {
            return addr;
        }
    }
    return NULL;
}

int main(int argc, const char * argv[]) {
    int data[3] = {1,2,3};
    int val = 2;
    // CLang 通用编程, 实现泛型的能力
    int index = LSearch(&val, data, 3, sizeof(int));
    printf("index = %d\n", index);
    return 0;
}
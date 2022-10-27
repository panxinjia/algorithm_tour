#include <stdio.h>

// 通用线性搜索
void * LSearch(void * key, void * base, int len, int elemSize,
                 int (*cmpFunc)(void *, void *)) {
    for (int i = 0; i < len; i++) {
        char * addr = (char *)base + (i * elemSize);
            if (cmpFunc(addr, key) == 0) {
                return addr;
            }
    }
    return NULL;
}

// 整形比较函数, 传入函数时, void * 被隐式转换成 int *, 所以不需要给出元素宽度
int IntCmp(int * vp1, int * vp2) {
    return *vp1 - *vp2;
}


int main(int argc, const * argv[]) {
    int array[5] = {22, 3, 10, 5, 98};
    int value = 10;
    void * addr = LSearch(&value, array, 5, sizeof(int), IntCmp);
    if (addr) {
        int ret = *(int *)addr;
        // 结果值
        printf("ret = %d\n", ret);
    }else {
        printf("elements not fount\n");
    }

    //TODO 完成字符串数组的搜索, 注意指针的跳数, 参数传递
    return 0;
}
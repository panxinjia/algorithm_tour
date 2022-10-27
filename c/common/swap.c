#include <string.h>
#include <stdlib.h>
#include "swap.h"

void Swap(void * vp1, void * vp2, int elemSize) {
    char * addr = (char *)malloc(elemSize);
    if (addr) {
        memcpy(addr, vp1, elemSize);
        memcpy(vp1, vp2, elemSize);
        memcpy(vp2, addr, elemSize);
        free(addr);
    }else {
        // 临时内存申请失败, 异常退出
        exit(EXIT_FAILURE);
    }
}
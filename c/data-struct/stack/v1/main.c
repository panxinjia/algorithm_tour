#include <stdio.h>

#include "stack.h"


// TODO C 栈结构实现
int main(int argc, const char * argv[]) {
    // main 函数结束时, 内存释放
    Stack stack;
    StackNew(&stack);

    for (int i = 0; i < 5; i++) {
        StackPush(&stack, i * 2 + 1);
    }

    for (int i = 0; i < 5; i++) {
        int ret = -1;
        StackPop(&stack, &ret);
        printf("stack(%d) -> %d\n", i, ret);
    }

    StackDispose(&stack);
    return 0;
}
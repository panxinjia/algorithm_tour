#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "stack.h"

void StackNew(Stack *stack){
    stack->allocLen = INIT_CAPACITY;
    stack->loginLen = 0;
    stack->elems = (int *)malloc(INIT_CAPACITY * sizeof(int));

    // 内存申请失败时, 退出程序
    assert(stack->elems != NULL);
}

void StackPush(Stack *stack, int elem){
    if (stack->loginLen == stack->allocLen) {
        // 内存容量不够, 需要扩容
        stack->elems = realloc(stack->elems, stack->allocLen * 2);
        stack->allocLen = stack->allocLen * 2;

        // 保证内存分配是成功的, 失败退出程序.
        assert(stack->elems != NULL);
    }
    stack->elems[stack->loginLen] = elem;
    stack->loginLen += 1;
}

int StackPop(Stack *stack, int * ret){
    if (stack->loginLen == 0) {
        // 栈为空, 返回-1, 表示错误
        return -1;
    }

    // 返回值赋值
    *ret = stack->elems[stack->loginLen - 1];
    stack->loginLen -= 1;
    // 返回0, 表示函数正常返回
    return 0;
}

// 栈结构是否为空
bool isEmpty(Stack *stack){
    return stack->loginLen == 0;
}

// 释放内存
void StackDispose(Stack *stack){
    if (stack->elems) {
        free(stack->elems);
        stack->loginLen = 0;
        stack->allocLen = 0;
    }
}
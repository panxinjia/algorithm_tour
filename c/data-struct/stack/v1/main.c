#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include <stdbool.h>

// #include "stack.h"


#ifndef _STACK_H_
    #define _STACK_H_

    // 初始栈空间大小
    #define INIT_CAPACITY 4

    // 栈结构定义
    typedef struct {
        int allocLen;
        int loginLen;
        int * elems;
    } Stack;

    // 栈结构操作函数, 第一个参数是栈数据结构
    void StackNew(Stack * stack);
    void StackPush(Stack * stack, int elem);
    int StackPop(Stack * stack, int * ret);
    bool isEmpty(Stack * stack);
    void StackDispose(Stack * stack);

#endif


// TODO C 栈结构实现, 调试代码
int main(int argc, const char * argv[]) {
    Stack stack;

    // 初始化
    StackNew(&stack);

    for (int i = 0; i < 5; i++) {
        StackPush(&stack, i + 1);
    }

    int ret = -1;
    // while (StackPop(&stack, &ret) != -1) {
        // printf("ret = %d\n", ret); 
    // }
    StackPop(&stack, &ret);
    printf("ret = %d\n", ret);

    StackPop(&stack, &ret);
    printf("ret = %d\n", ret);
    StackPop(&stack, &ret);
    printf("ret = %d\n", ret);

    StackPop(&stack, &ret);
    printf("ret = %d\n", ret);

    StackPop(&stack, &ret);
    printf("ret = %d\n", ret);
    // printf("isEmpty -> %d\n", isEmpty(&stack));

    // 释放内存
    StackDispose(&stack);
    return 0;
}


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
    stack->loginLen ++;
}

int StackPop(Stack *stack, int * ret){
    if (stack->loginLen == 0) {
        // 栈为空, 返回-1, 表示错误
        return -1;
    }

    // 返回值赋值, 从内存末尾弹出元素
    *ret = stack->elems[stack->loginLen - 1];
    stack->loginLen --;
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
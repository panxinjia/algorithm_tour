#include <stdbool.h>


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
#include <stdio.h>

int LSearch(int key, int array[], int len) {
    for (int i = 0; i < len; i++) {
        if (key == array[i]) {
            return i;
        }
    }
    return -1;
}

int main(int argc, const char * argv) {
    printf("hello world\n");
    return 0;

}
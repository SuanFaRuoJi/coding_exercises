//
// Created by Shaoze Wang on 10/8/19.
//

#include <stdio.h>

int uptree[30001][3];

int find(int node, bool value){
    int result = 0, cur = node;
    while(uptree[cur][0]){
        result += uptree[cur][1] + 1; // everything below it plus its parent
        cur = uptree[cur][0];
    }
    if (uptree[node][0]){
        uptree[node][0] = cur;
        uptree[node][1] = result - 1;
    }
    return value ? result : cur;
}

void merge(int from, int to){
    uptree[from][0] = to;
    uptree[from][1] += uptree[to][2];
    uptree[to][2] += uptree[from][2] + 1; // total number of the stack except self
}

int main(){
    int size;
    scanf("%d", &size);
    //printf("%d\n", size);
    int i = 0;
    // seed the tree
    while(i++ < size){
        char command;
        scanf(" %c", &command);
        if (command == 'M'){
            int X, Y;
            scanf("%d %d", &X, &Y);
            int X_top = find(X, false);
            int Y_top = find(Y, false);
            merge(X_top, Y_top);
            //printf("%c: %d %d\n", command, X, Y);
        }else{
            int cur;
            scanf("%d", &cur);
            int result = find(cur, true);
            printf("%d\n", result);
            //printf("%c: %d\n", command, cur);
        }
        /*
        for (int index=1; index<=size; index++){
            fprintf(stderr, "%d: %d %d %d\n", index, uptree[index][0], uptree[index][1], uptree[index][2]);
        }
         */
    }

    return 0;
}
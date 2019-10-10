//
// Created by Shaoze Wang on 10/9/19.
//

/* TODO: edge case of 2, give each entry a parent, and group relative to its parent.
 * TODO: when comparing two entries, if not the same group, then not sure.
 * TODO: then if same group, then compare their quality both with head, same result then same, otherwise different.
 * */
#include <stdio.h>
#include <string.h>
struct node{
    node(): parent(0), diff_as_parent(false), rank(0) {}
    int parent;
    bool diff_as_parent;
    int rank;
} uptree[100001];

int find(int index){
    if (!uptree[index].parent){
        return index;
    }
    int cur = uptree[index].parent;
    while(uptree[cur].parent){
        uptree[index].diff_as_parent = (uptree[index].diff_as_parent != uptree[cur].diff_as_parent);
        cur = uptree[cur].parent;
        uptree[index].parent = cur;
    }
    return cur;
}

void merge(int a, int b){
    int a_parent = find(a), b_parent = find(b);
    if (a_parent == b_parent){
        return;
    }
    int a_parent_rank = uptree[a_parent].rank, b_parent_rank = uptree[b_parent].rank;
    if (a_parent_rank >= b_parent_rank){
        uptree[b_parent].parent = a_parent;
        uptree[b_parent].diff_as_parent = (uptree[a].diff_as_parent == uptree[b].diff_as_parent);
        uptree[a_parent].rank = b_parent_rank+1 > a_parent_rank ? b_parent_rank+1 : a_parent_rank;
    }else{
        uptree[a_parent].parent = b_parent;
        uptree[a_parent].diff_as_parent = (uptree[a].diff_as_parent == uptree[b].diff_as_parent);
        uptree[b_parent].rank = a_parent_rank+1 > b_parent_rank ? a_parent_rank+1 : b_parent_rank;
    }
}

int main(){
    int size;
    scanf("%d", &size);
    for (int i=0; i<size; i++){
        int num_op, total;
        scanf("%d%d", &total, &num_op);
        //fprintf(stderr, "%d operations on %d members\n", num_op, total);
        memset(uptree+1, 0, total*sizeof(node));
        for (int j=0; j<num_op; j++){
            char command;
            int a, b;
            scanf(" %c %d %d", &command, &a, &b);
            //fprintf(stderr, "command: %c on %d and %d\n", command, a, b);
            if (command == 'D'){
                //int a_parent = find(uptree, a);
                //int b_parent = find(uptree, b);
                merge(a, b);
            }else{
                if (total == 2){
                    printf("In different gangs.\n");
                    continue;
                }
                int a_parent = find(a);
                int b_parent = find(b);
                if (a_parent != b_parent){
                    printf("Not sure yet.\n");
                }else{
                    if (uptree[a].diff_as_parent != uptree[b].diff_as_parent){
                        printf("In different gangs.\n");
                    }else{
                        printf("In the same gang.\n");
                    }
                }
            }
            /*
            for (int index = 1; index <= total; index++){
                node& cur = uptree[index];
                fprintf(stderr, "%d: %d %d %d\n", index, cur.parent, cur.diff_as_parent, cur.rank);
            }
            */
        }
    }
    return 0;
}


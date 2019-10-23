//
// Created by Shaoze Wang on 10/21/19.
//

#include <stdio.h>

/*
 * TODO
 *  Implement 2-D BIT. bit_forest[][].
 *  Update x, y, val ->
 *  cur_x = x
 *  while cur_x < height
 *      update bit_forest[cur_x], y, val
 *      cur_x += cur_x & (-cur_x)
 *  Find L, B, R, T ->
 *      a <- find bit_forest[T], L
 *      b <- find bit_forst[B], L
 *      a <- a-b
 *      c <- find bit_forest[T], R
 *      d <- find bit_forest[B], R
 *      c <- c-d
 *      return c-a
 * */

int bit_forest[1025][1025];
int height, width;

void update_forest(int, int, int);
int find_forest(int, int);
void update_tree(int, int, int);
int find_tree(int, int);

inline void update_forest(int x, int y, int val){
    int cur_x = x;
    while(cur_x <= height){
        update_tree(cur_x, y, val);
        cur_x += cur_x & (-cur_x);
    }
}

inline void update_tree(int x, int y, int val){
    int cur = y;
    while(cur <= width){
        bit_forest[x][cur] += val;
        cur += cur & (-cur);
    }
}

inline int find_forest(int x, int y){
    int cur_x = x, amount = 0;
    while(cur_x > 0){
        amount += find_tree(cur_x, y);
        cur_x -= cur_x & (-cur_x);
    }
    return amount;
}

inline int find_tree(int x, int y){
    int cur = y, amount = 0;
    while(cur > 0){
        amount += bit_forest[x][cur];
        cur -= cur & (-cur);
    }
    return amount;
}

int main(){
    int cmd = 0;
    do{
        scanf("%d", &cmd);
        if (cmd == 0){
            int s;
            scanf("%d", &s);
            height = s;
            width = s;
            //fprintf(stderr, "%d: %d\n", cmd, s);
        }else{
            if (cmd == 1){
                int x, y, a;
                scanf("%d %d %d", &x, &y, &a);
                update_forest(x+1, y+1, a);
                //fprintf(stderr, "%d: %d %d %d\n", cmd, x, y, a);
            }else{
                if (cmd == 2){
                    int l, b, r, t;
                    scanf("%d %d %d %d", &l, &b, &r, &t); // l,b for x, r,t for y
                    int bl = find_forest(l, b);
                    int br = find_forest(r+1, b);
                    int tl = find_forest(l, t+1);
                    int tr = find_forest(r+1, t+1);
                    printf("%d\n", (tr-tl)-(br-bl));
                    //fprintf(stderr, "%d: %d %d %d %d\n", cmd, l, b, r, t);
                }
            }
        }
        //inspect();
        getchar();
    }while(cmd != 3);
    return 0;
}

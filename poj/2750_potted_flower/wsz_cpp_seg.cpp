//
// Created by Shaoze Wang on 10/24/19.
//

#include "wsz_cpp_seg.h"

int flowers[100000];

typedef struct seg_node{
    int l, r;
    int sum, max; // range sum, max sub range sum
    int l_min, l_max, r_min, r_max; // starting from the mid point, min/max values going to left/right
    seg_node * l_child, * r_child;

    seg_node(int _l, int _r){

        l = _l;
        r = _r;
        if (_l == _r){
            sum = flowers[_l];
            max = sum > 0 ? sum : 0;
            l_max = max;
            r_max = max;
            l_min = sum - max;
            r_min = sum - max;
            l_child = 0;
            r_child = 0;
            display();
            return;
        }
        int mid = (l+r)/2;
        l_child = new seg_node(l, mid);
        r_child = new seg_node(mid+1, r);
        sum = l_child->sum + r_child->sum;
        max = l_child->max > r_child->max ? l_child->max : r_child->max;

        int length = r-l+1, l_base = l_child->r_child ? l_child->r_child->sum : 0, r_base = r_child->l_child ? r_child->l_child->sum : 0;
        int l_max_a = l_base + l_child->l_max, l_max_b = l_base - l_child->r_min;
        l_max = l_max_a > l_max_b ? l_max_a : l_max_b;

        int r_max_a = r_base + r_child->r_max, r_max_b = r_base - r_child->l_min;
        r_max = r_max_a > r_max_b ? r_max_a : r_max_b;

        int l_min_a = l_base + l_child->l_min, l_min_b = l_base - l_child->r_max;
        l_min = l_min_a < l_min_b ? l_min_a : l_min_b;

        int r_min_a = r_base + r_child->r_min, r_min_b = r_base - r_child->l_max;
        r_min = r_min_a < r_min_b ? r_min_a : r_min_b;

        int level_max = l_max + r_max;
        max = max > level_max ? max : level_max;
        display();
    }

    void display(){
        printf("<%d, %d>: max: %d, sum: %d, l_min: %d, l_max: %d, r_min: %d, r_max: %d\n", l, r, max, sum, l_min, l_max, r_min, r_max);
    }

    void update(int index){
        int length = r-l+1;
        if (length == 1){
            sum = flowers[index];
            max = sum > 0 ? sum : 0;
            l_max = max;
            r_max = max;
            l_min = sum - max;
            r_min = sum - max;
            l_child = 0;
            r_child = 0;
            display();
            return;
        }
        int mid = (r+l)/2;
        if (index <= mid){
            l_child -> update(index);
        }else{
            r_child -> update(index);
        }

        sum = l_child->sum + r_child->sum;
        max = l_child->max > r_child->max ? l_child->max : r_child->max;

        int l_base = l_child->r_child ? l_child->r_child->sum : 0, r_base = r_child->l_child ? r_child->l_child->sum : 0;

        int l_max_a = l_base + l_child->l_max, l_max_b = l_base - l_child->r_min;
        l_max = l_max_a > l_max_b ? l_max_a : l_max_b;

        int r_max_a = r_base + r_child->r_max, r_max_b = r_base - r_child->l_min;
        r_max = r_max_a > r_max_b ? r_max_a : r_max_b;

        int l_min_a = l_base + l_child->l_min, l_min_b = l_base - l_child->r_max;
        l_min = l_min_a < l_min_b ? l_min_a : l_min_b;

        int r_min_a = r_base + r_child->r_min, r_min_b = r_base - r_child->l_max;
        r_min = r_min_a < r_min_b ? r_min_a : r_min_b;

        int level_max = l_max + r_max;
        max = max > level_max ? max : level_max;
        display();
    }
} node;

int main(){
    int size;
    scanf("%d", &size);
    getchar();
    for (int i=0; i<size; i++){
        int cur;
        scanf("%d", &cur);
        flowers[i] = cur;
    }
    getchar();
    seg_node * root = new seg_node(0, size-1);
    int ops;
    scanf("%d", &ops);
    getchar();
    while(ops--){
        int index, val;
        scanf("%d %d", &index, &val);
        getchar();
        flowers[index] = val;
        root -> update(index);
        printf("%d\n", root->max);
    }

}
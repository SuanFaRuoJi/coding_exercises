//
// Created by Shaoze Wang on 10/24/19.
//

#include <stdio.h>
int flowers[100000];

typedef struct seg_node{
    int l, r;
    int sum, max, min; // range sum, max sub range sum
    int l_min, l_max, r_min, r_max; // starting from the mid point, min/max values going to left/right
    int min_elem;
    seg_node * l_child, * r_child;

    seg_node(int _l, int _r){
        l = _l;
        r = _r;
        if (_l == _r){
            sum = flowers[_l];
            max = sum > 0 ? sum : 0;
            min = sum - max;
            l_max = 0;
            r_max = 0;
            l_min = 0;
            r_min = 0;
            l_child = 0;
            r_child = 0;
            min_elem = flowers[_l];
            //display();
            return;
        }
        int mid = (l+r)/2;
        l_child = new seg_node(l, mid);
        r_child = new seg_node(mid+1, r);
        sum = l_child->sum + r_child->sum;
        max = l_child->max > r_child->max ? l_child->max : r_child->max;
        min = l_child->min < r_child->min ? l_child->min : r_child->min;
        min_elem = l_child->min_elem < r_child->min_elem ? l_child->min_elem : r_child->min_elem;

        if (l_child -> r_child){
            int l_max_a = l_child->r_child->sum + l_child->l_max, l_max_b = l_child->r_child->sum - l_child->r_min;
            l_max = l_max_a > l_max_b ? l_max_a : l_max_b;
            int l_min_a = l_child->r_child->sum + l_child->l_min, l_min_b = l_child->r_child->sum - l_child->r_max;
            l_min = l_min_a < l_min_b ? l_min_a : l_min_b;
        } else{
            l_max = l_child->max;
            l_min = l_child->sum - l_child->max;
        }

        if (r_child -> l_child){
            int r_max_a = r_child->l_child->sum + r_child->r_max, r_max_b = r_child->l_child->sum - r_child->l_min;
            r_max = r_max_a > r_max_b ? r_max_a : r_max_b;
            int r_min_a = r_child->l_child->sum + r_child->r_min, r_min_b = r_child->l_child->sum - r_child->l_max;
            r_min = r_min_a < r_min_b ? r_min_a : r_min_b;
        } else{
            r_max = r_child->max;
            r_min = r_child->sum - r_child->max;
        }

        int level_max = l_max + r_max;
        max = max > level_max ? max : level_max;

        int level_min = l_min + r_min;
        min = min < level_min ? min : level_min;
        //display();
    }

    void display(){
        fprintf(stderr, "<%d, %d>: max: %d, min: %d, sum: %d, l_min: %d, l_max: %d, r_min: %d, r_max: %d\n", l, r, max, min, sum, l_min, l_max, r_min, r_max);
    }

    void update(int index){
        int length = r-l+1;
        if (length == 1){
            sum = flowers[index];
            max = sum > 0 ? sum : 0;
            min = sum - max;
            min_elem = flowers[index];
            //display();
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
        min = l_child->min < r_child->min ? l_child->min : r_child->min;
        min_elem = l_child->min_elem < r_child->min_elem ? l_child->min_elem : r_child->min_elem;

        if (l_child -> r_child){
            int l_max_a = l_child->r_child->sum + l_child->l_max, l_max_b = l_child->r_child->sum - l_child->r_min;
            l_max = l_max_a > l_max_b ? l_max_a : l_max_b;
            int l_min_a = l_child->r_child->sum + l_child->l_min, l_min_b = l_child->r_child->sum - l_child->r_max;
            l_min = l_min_a < l_min_b ? l_min_a : l_min_b;
        } else{
            l_max = l_child->max;
            l_min = l_child->sum - l_child->max;
        }

        if (r_child -> l_child){
            int r_max_a = r_child->l_child->sum + r_child->r_max, r_max_b = r_child->l_child->sum - r_child->l_min;
            r_max = r_max_a > r_max_b ? r_max_a : r_max_b;
            int r_min_a = r_child->l_child->sum + r_child->r_min, r_min_b = r_child->l_child->sum - r_child->l_max;
            r_min = r_min_a < r_min_b ? r_min_a : r_min_b;
        } else{
            r_max = r_child->max;
            r_min = r_child->sum - r_child->max;
        }

        int level_max = l_max + r_max;
        max = max > level_max ? max : level_max;

        int level_min = l_min + r_min;
        min = min < level_min ? min : level_min;
        //display();
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
    //fprintf(stderr, "Initialized\n");
    seg_node * root = new seg_node(0, size-1);
    int ops;
    scanf("%d", &ops);
    getchar();
    while(ops--){
        int index, val;
        scanf("%d %d", &index, &val);
        index --;
        getchar();
        flowers[index] = val;
        //fprintf(stderr, "Updated\n");
        root -> update(index);
        int max1 = root -> max; // linear max
        int max2 = root -> sum - root -> min;
        int max = max1 > max2 ? max1 : max2;
        if (max == root->sum){
            max -= root->min_elem;
        }
        printf("%d\n", max);
    }
}
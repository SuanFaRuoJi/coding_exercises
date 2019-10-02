//
// Created by Shaoze Wang on 10/2/19.
//

#include "wsz_cpp_2.h"

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums){
        int length = nums.size(), min = 0, max = 0;
        if (length <= 1){
            return vector<int>(length, 0);
        }
        for (int i=0; i<length; i++){
            if (i == 0 || nums[i] < min){
                min = nums[i];
            }
            if (i == 0 || nums[i] > max){
                max = nums[i];
            }
        }
        int bush_size = max-min+2;
        vector<int> tree(bush_size, 0);
        vector<int> result(length);
        for (int i=length-1; i>=0; i--){
            int cur = nums[i] - min + 1;
            result[i] = (find(tree, cur-1));
            update(tree, cur);
        }
        return result;
    }

    void update(vector<int>& tree, int key){ // do lazy update and start from the last entry
        while(key < tree.size()){
            tree[key] += 1;
            key += (key & (-key));
        }
        return;
    }

    int find(vector<int>& tree, int key){
        int sum = 0;
        while(key > 0){ // not >= since 0 is dummy node
            sum += tree[key];
            key -= (key & (-key));
        }
        return sum;
    }
};
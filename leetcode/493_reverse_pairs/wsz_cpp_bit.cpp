//
// Created by Shaoze Wang on 10/2/19.
//

#include "wsz_cpp.h"

typedef long long ll;

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int length = nums.size();
        if (length <= 1){
            return 0;
        }
        vector<int> tree (length, 0);
        vector<pair<long, int> > transpose;
        for (int i=0; i<length; i++){
            transpose.push_back(pair<long, int>((ll)nums[i], i));
        }

        sort(transpose.begin(), transpose.end(), greater<pair<long, int>>());
        // now it's indices ordered by the value of their entries.

        int i=0, sum=0;
        for (int j=0; j<length; j++){
            while(i<length && transpose[j].first*2 < transpose[i].first){
                update(tree, transpose[i].second+1, 1);
                i++;
            }
            sum += find(tree, transpose[j].second);
        }
        return sum;
    }

    void update(vector<int>& tree, int key, int delta){
        for (; key<tree.size(); key+= key & (-key)){
            tree[key] += delta;
        }
    }

    int find(vector<int>& tree, int key){
        int sum = 0;
        for (;key; key-= key & (-key)){
            sum += tree[key];
        }
        return sum;
    }
};
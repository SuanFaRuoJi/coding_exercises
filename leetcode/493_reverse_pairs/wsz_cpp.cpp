//
// Created by Shaoze Wang on 10/2/19.
//

#include "wsz_cpp.h"

typedef long long ll;

class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int length = nums.size(), sum = 0;
        if (length <= 1){
            return 0;
        }
        vector<int> tree (length+1);

        // turn (index, value) pair into (value, index) pair for large min-max distance
        vector<pair<ll, int> > transpose;
        for (int i=0; i<length; i++){
            transpose.push_back(pair<ll, int>(nums[i], i));
        }

        sort(transpose.begin(), transpose.end(), greater<pair<ll, int>>());
        // now it's indices ordered by the value of their entries.

        int i=1, sum=0;
        for (int j=length-1; j>=0; j--){
            while(i<length && transpose[j].first > transpose[i].first * 2){
                update(tree, i, 1);
                // now tree contains all indices whose values * 2 < current index's value, can use Fenwick to check
                // how many those indices < than current index;
                i++;
            }
            sum += find(tree, j);
        }
        return sum;
    }

    void update(vector<int>& tree, int key, int delta){
        for (; key<tree.size(); k+= k & (-k)){
            tree[key] += delta;
        }
    }

    int find(vector<int>& tree, int key){
        int sum = 0;
        for (;key; k-= k & (-k)){
            sum += tree[key];
        }
        return sum;
    }
};
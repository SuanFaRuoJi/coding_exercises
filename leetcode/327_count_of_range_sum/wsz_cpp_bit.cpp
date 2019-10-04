//
// Created by Shaoze Wang on 10/3/19.
//

#include "wsz_cpp_bit.h"
typedef long long ll;

class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        ll sum = 0;
        int length = nums.size();
        if (length <= 0){
            return 0;
        }
        vector<pair<ll, int>> prefix_sums;
        prefix_sums.push_back(pair<ll, int>(0, 0));
        for (int i=0; i<length; i++){
            sum += nums[i];
            prefix_sums.push_back(pair<ll, int>(sum, i+1));
        }
        sort(prefix_sums.begin(), prefix_sums.end(), greater<pair<ll, int>>());

        cout << "Upper:" << endl;
        int upper_result = count_ranges(prefix_sums, upper);
        cout << "Lower:" << endl;
        int lower_result = count_ranges(prefix_sums, limit-1);

        return upper_result - lower_result;
    }

    void update(vector<int>& tree, int index){
        for(; index < tree.size(); index += index & (-index)){
            tree[index] ++;
        }
    }

    int find(vector<int>& tree, int index){
        int sum = 0;
        for (; index; index -= index & (-index)){
            sum += tree[index];
        }
        return sum;
    }

    int count_ranges(vector<pair<ll, int>>& arr, int limit){
        vector<int> tree (arr.size()+1);
        int i = 0, j = 0, result = 0;
        for (; i<arr.size(); i++){
            while (j<length && arr[i].first-arr[j].second <= limit){
                update(tree, arr[j].second+1);
                j++;
            }
            result += find(tree, arr[i].second);
            cout << i << " " << j << " " << result;
        }
        return result;
    }
};
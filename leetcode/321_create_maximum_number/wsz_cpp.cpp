//
// Created by Shaoze Wang on 10/14/19.
//

#include "wsz_cpp.h"


int offer(vector<int> nums, int index, int other_l, int k){
    int max = -1, max_index = -1;
    while(index < nums.size() && nums.size()-index+other_l >= k){
        if (nums[index] > max){
            max = nums[index];
            max_index = index;
        }
        index++;
    }
    return max_index;
}

vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
    int a_start = 0, b_start = 0, a_l = nums1.size(), b_l = nums2.size();
    vector<int> result;
    while(k){
        int a_offer = offer(nums1, a_start, b_l-b_start, k), b_offer = offer(nums2, b_start, a_l-a_start, k);
        int a_val = a_offer==-1 ? -1 : nums1[a_offer], b_val = b_offer==-1 ? -1 : nums2[b_offer];
        if (a_val > b_val){
            result.push_back(a_val);
            a_start = a_offer+1;
        }else{
            if (a_val < b_val){
                result.push_back(b_val);
                b_start = b_offer+1;
            }else{
                result.push_back(a_val);

            }
        }
        k--;
    }
    return result;
}

int main(){
    vector<int> nums1 {3,9};
    vector<int> nums2 {8,9};
    vector<int> result = maxNumber(nums1, nums2, 3);
    for (int i=0; i<result.size(); i++){
        cout << result[i] << endl;
    }
    return 0;
}

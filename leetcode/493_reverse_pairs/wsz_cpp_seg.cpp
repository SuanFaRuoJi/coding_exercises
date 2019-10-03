//
// Created by Shaoze Wang on 10/3/19.
//

#include "wsz_cpp_seg.h"
typedef long long ll;

class Solution {
public:
    class SegNode{
    public:
        ll l, r;
        int count;
        SegNode * l_node, * r_node;

        SegNode(ll l_bound, ll r_bound){
            l = l_bound;
            r = r_bound;
            count = 0;
            l_node = nullptr;
            r_node = nullptr;
        }

        void add(ll val){

            if (l > val || r < val){
                return;
            }
            //cout << "Add " << val << " at " << l << ", " << r << endl;
            count ++;
            if (l == r){
                return;
            }
            double mid = floor((l+r)/2);
            if (!l_node){
                l_node = new SegNode(l, mid);
            }
            l_node->add(val);
            if (!r_node){
                r_node = new SegNode(mid+1, r);
            }
            r_node->add(val);
        }

        int find(ll l_bound, ll r_bound){
            //cout << "look at " << l << ", " << r << endl;
            if (r <= r_bound && l >= l_bound){
                return count;
            }
            if (l > r_bound || r < l_bound){
                return 0;
            }
            return (l_node ? l_node->find(l_bound, r_bound) : 0) + (r_node ? r_node->find(l_bound, r_bound) : 0);
        }
    };

    int reversePairs(vector<int>& nums) {
        int length = nums.size();
        if (length <= 1){
            return 0;
        }
        vector<pair<ll, int>> transpose;
        for (int i=0; i<length; i++){
            transpose.push_back(pair<ll, int>(nums[i], i));
        }
        sort(transpose.begin(), transpose.end());
        SegNode root(0, length-1);
        int j = 0, result = 0;
        for (int i=0; i<length; i++){
            while(j < length && transpose[j].first * 2 < transpose[i].first){
                root.add(transpose[j].second);
                j++;
            }
            //cout << "find: " << transpose[i].second + 1 << ", " << length - 1 << endl;
            result += root.find(transpose[i].second+1, length-1);
            //cout << transpose[i].first << " " << transpose[i].second << " " << j << " " << result << endl;
        }
        return result;
    }
};
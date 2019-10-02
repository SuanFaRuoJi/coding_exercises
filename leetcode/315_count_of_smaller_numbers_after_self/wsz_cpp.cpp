//
// Created by Shaoze Wang on 10/1/19.
// MergeSort solution.
//

#include "wsz_cpp.h"

using namespace std;

struct comparator {
    bool operator() (vector<int> i, vector<int> j) {return (i[0] < j[0]);}
} sort_operator;

class Solution{
public:
    vector<int> countSmaller(vector<int>& nums) {
        if (nums.size() == 0){
            vector<int> result;
            return result;
        }
        vector<int> amount (nums.size(), 0);
        vector<int> indices (nums.size(), 0);
        iota(indices.begin(), indices.end(), 0);
        for (auto i = indices.begin(); i != indices.end(); i++){
            cout << *i << " ";
        }
        cout << endl;
        recursion(nums, indices, amount, 0, nums.size()-1);

        return vector<int>(amount.begin(), amount.end());
    }

    void recursion(vector<int>& vals, vector<int>& indices, vector<int>& amount, int l, int r){
        int length = r-l+1;
        if (length == 1) {
            return;
        }

        if (length == 2){
            int a = vals[indices[l]], b = vals[indices[r]];
            if (a > b){
                cout << l << " " << r << endl;
                int t = indices[l];
                indices[l] = indices[r];
                indices[r] = t;
                amount[indices[l]] += 1;
            }
            return;
        }

        int mid = (l+r)/2, accumulate = 0;
        recursion(vals, indices, amount, l, mid);
        recursion(vals, indices, amount, mid+1, r);
        vector<int> temp;
        int front = l, back = mid+1;
        while(front <= mid || back <= r){
             while(back <= r && (front > mid || vals[indices[back]] < vals[indices[front]])){
                 temp.push_back(indices[back]);
                 accumulate ++;
                 back ++;
             }
             while(front <= mid && (back > r || vals[indices[front]] <= vals[indices[back]])){
                 temp.push_back(indices[front]);
                 amount[indices[front]] += accumulate;
                 front ++;
             }
        }
        move(temp.begin(), temp.end(), indices.begin() + l);
        return;
    }

};

int main(){
    vector<int> data {5,6,6,8,0,5,10,3,17,6,8,6,10,3,6,8,0,5};
    Solution tester;
    auto result = tester.countSmaller(data);
    for (auto i = result.begin(); i != result.end(); i++){
        cout << (*i) << " ";
    }
    cout << endl;
    return 0;
}
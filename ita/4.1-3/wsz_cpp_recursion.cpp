//
// Created by Shaoze Wang on 10/10/19.
//

#include <vector>
#include <limits>
#include <algorithm>

using namespace std;

int recursion_maximum_subarray(vector<int> &arr, int l, int r){
    if (l == r){
        return arr[l];
    }
    int mid = (l+r)/2;
    int l_result = recursion_maximum_subarray(arr, l, mid);
    int r_result = recursion_maximum_subarray(arr, mid+1, r);
    int r_cross = mid+1, r_max = numeric_limits<int>::min(), l_cross = mid, l_max = numeric_limits<int>::min(), partial_result = 0;
    for (; r_cross<=r; r_cross++){
        partial_result += arr[r_cross];
        if (partial_result > r_max){
            r_max = partial_result;
        }
    }
    partial_result = 0;
    for (; l_cross>=0; l_cross--){
        partial_result += arr[l_cross];
        if (partial_result > l_max){
            l_max = partial_result;
        }
    }
    return max(l_result, max(r_result, l_max+r_max));
}

int main(){
    printf("Please enter a list of integers, separated by enter and terminated by EOF\n");
    vector<int> input;
    int cur;
    while(scanf("%d", &cur) != EOF){
        input.push_back(cur);
    }
    printf("The maximum sum for any subarray is %d\n", recursion_maximum_subarray(input, 0, input.size()-1));
}

//
// Created by Shaoze Wang on 10/10/19.
//

#include <vector>
#include <stdio.h>
#include <limits>

using namespace std;

int brute_force_maximum_subarray(vector<int> &arr){
    int length = arr.size();
    int MAX = numeric_limits<int>::min();
    for (int i=0; i<length; i++){
        int partial_sum = 0;
        for (int j=i; j<length; j++){
            partial_sum += arr[j];
            if (partial_sum > MAX){
                MAX = partial_sum;
            }
        }
    }
    return MAX;
}

int main(){
    printf("Please enter a list of integers, separated by enter and terminated by EOF\n");
    vector<int> input;
    int cur;
    while(scanf("%d", &cur) != EOF){
        input.push_back(cur);
    }
    printf("The maximum sum for any subarray is %d\n", brute_force_maximum_subarray(input));
}

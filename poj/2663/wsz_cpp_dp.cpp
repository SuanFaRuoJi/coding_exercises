//
// Created by Shaoze Wang on 10/28/19.
//

#include "wsz_cpp_dp.h"

#include <stdio.h>
int dp[31];

int main(){
    dp[0] = 1;
    dp[1] = 2;
    dp[2] = 3;
    int max = 2, cur;
    do{
        scanf("%d", &cur);
        getchar();
        for (int i=max+1; i<=cur; i++){
            if (i%2 == 0){
                dp[i] = dp[i-2]+ dp[i-1];
            }else{
                dp[i] = dp[i-1] * 2 + dp[i-2];
            }
        }
        if (cur != -1){
            if (cur%2 == 0){
                printf("%d\n", dp[cur]);
            }else{
                printf("0\n");
            }
        }
        if (cur > max){
            max = cur;
        }
    }while(cur != -1);
    return 0;
}
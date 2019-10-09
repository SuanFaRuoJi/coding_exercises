#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <algorithm>

bool comp(int i, int j){return (i<j);}

int main(){
    int size=0;
    scanf("%d", &size);
    int arr[2*size];
    int * quadrant = (int *)malloc(sizeof(int)*size);

    for (int i=0; i<size*2; i++){
        scanf("%d", arr+i);
    }

    int prev = 0, x_s = 0, y_s = 0;
    for (int i=0; i<size; i++){
        scanf("%d", quadrant+i);
        if (prev != 0){
            if (prev == quadrant[i]){
                x_s ++;
                y_s ++;
            }
            else{
                if (prev + quadrant[i] == 5){
                    x_s ++;
                }else{
                    if (abs(prev-quadrant[i]) == 1){
                        y_s ++;
                    }
                }
            }
        }
        prev = quadrant[i];
    }


    std::sort(arr, arr+2*size, comp);

    int * x = (int *)malloc(sizeof(int)*size);
    int * y = (int *)malloc(sizeof(int)*size);

    for (int i=0; i<size; i++){
        if (quadrant[size-1]==1||quadrant[size-1]==4){
            if ((size-1-i)%2!=0){
                arr[i] = -arr[i];
            }
        }else{
            if ((size-1-i)%2!=1){
                arr[i] = -arr[i];
            }
        }

        if (quadrant[size-1]==1||quadrant[size-1]==2){
            if ((size*2-1-i)%2!=0){
                arr[size+i] = -arr[size+i];
            }
        }else{
            if ((size*2-1-i)%2!=1){
                arr[size+i] = -arr[size+i];
            }
        }
    }
    prev = 0;



    int x_l = x_s-1, x_r = x_s, y_l = y_s-1, y_r = y_s;
    for (int i=0; i<size; i++){
        if (prev != 0 && (prev+quadrant[i] == 5 || prev == quadrant[i])){
            x[i] = arr[x_l--];
        }
        else{
            x[i] = arr[x_r++];
        }
        if (prev==0 || prev+quadrant[i]==5 || abs(prev-quadrant[i])==2){
            y[i] = arr[size+y_r++];
        }else{
            y[i] = arr[size+y_l--];
        }
        prev = quadrant[i];
        printf("%+d %+d\n", x[i], y[i]);
    }

}
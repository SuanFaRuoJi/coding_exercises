//
// Created by Shaoze Wang on 10/23/19.
//

#include <stdio.h>
#include <vector>

using namespace std;

class NumMatrix {
    int height, width;
    vector<vector<int>> bit_forest;
    vector<vector<int>> * mat;

    int query(int row, int col){
        int amount = 0;
        while(row > 0){
            int cur = col;
            while(cur > 0){
                amount += bit_forest[row][cur];
                cur -= cur & (-cur);
            }
            row -= row & (-row);
        }
        return amount;
    }

public:
    NumMatrix(vector<vector<int>>& matrix) {
        height = matrix.size();
        if (height == 0){
            return;
        }
        width = matrix[0].size();
        if (width == 0){
            return;
        }
        bit_forest = vector<vector<int>>(height+1, vector<int> (width+1, 0));
        mat = &matrix;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                int val = matrix[i][j];
                matrix[i][j] = 0;
                update(i, j, val);
            }
        }
    }

    void update(int row, int col, int val) {
        int diff = val - (*mat)[row][col];
        (*mat)[row][col] = val;
        row += 1;
        col += 1;
        while(row <= height){
            int cur = col;
            while(cur <= width){
                bit_forest[row][cur] += diff;
                cur += cur & (-cur);
            }
            row += row & (-row);
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        int a = query(row2+1, col2+1), b = query(row2+1, col1), c = query(row1, col2+1), d = query(row1, col1);
        //printf("%d %d %d %d\n", a, b, c, d);
        return a - b + d - c;
    }
};

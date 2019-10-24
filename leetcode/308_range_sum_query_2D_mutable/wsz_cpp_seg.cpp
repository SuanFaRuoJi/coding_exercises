//
// Created by Shaoze Wang on 10/23/19.
//

#include <vector>
#include <stdio.h>

using namespace std;

class segtree {
public:
    int row1, row2, col1, col2;
    int quantity;
    segtree * child_11, * child_12, * child_21, *child_22; // <row, col>

    segtree(){
        child_11 = 0;
        child_12 = 0;
        child_21 = 0;
        child_22 = 0;
        quantity = 0;
    }

    void update(int row, int col, int diff){
        if (row1 <= row && row <= row2 && col1 <= col && col <= col2){
            quantity += diff;
        }

        if (row < row1 || row > row2 || col < col1 || col > col2){
            return;
        }
        int height = row2-row1+1, width = col2-col1+1;
        if (height == 1 && width == 1){
            return;
        }
        int mid_row = (row1+row2)/2, mid_col = (col1+col2)/2;
        if (row <= mid_row){
            if (col <= mid_col){ //11
                if (! child_11){
                    child_11 = new segtree();
                    child_11->row1 = row1;
                    child_11->row2 = mid_row;
                    child_11->col1 = col1;
                    child_11->col2 = mid_col;
                }
                child_11 -> update(row, col, diff);
            }else{ //12
                if (! child_12){
                    child_12 = new segtree();
                    child_12->row1 = row1;
                    child_12->row2 = mid_row;
                    child_12->col1 = mid_col+1;
                    child_12->col2 = col2;
                }
                child_12 -> update(row, col, diff);
            }
        }else{
            if (col <= mid_col){ //21
                if (! child_21){
                    child_21 = new segtree();
                    child_21->row1 = mid_row+1;
                    child_21->row2 = row2;
                    child_21->col1 = col1;
                    child_21->col2 = mid_col;
                }
                child_21 -> update(row, col, diff);
            }else{ //22
                if (! child_22){
                    child_22 = new segtree();
                    child_22->row1 = mid_row+1;
                    child_22->row2 = row2;
                    child_22->col1 = mid_col+1;
                    child_22->col2 = col2;
                }
                child_22 -> update(row, col, diff);
            }
        }
    }

    int query(int _row1, int _row2, int _col1, int _col2){
        if (_row1 <= row1 && row2 <= _row2 && _col1 <= col1 && col2 <= _col2){
            return quantity; // completely included
        }
        if (_row1 > row2 || _row2 < row1 || _col1 > col2 || _col2 < col1){
            return 0;
        }
        int amount = 0;
        if (child_11){
            amount += child_11 -> query(_row1, _row2, _col1, _col2);
        }
        if (child_12){
            amount += child_12 -> query(_row1, _row2, _col1, _col2);
        }
        if (child_21){
            amount += child_21 -> query(_row1, _row2, _col1, _col2);
        }
        if (child_22){
            amount += child_22 -> query(_row1, _row2, _col1, _col2);
        }
        return amount;
    }
};

class NumMatrix {
    segtree * root;
    vector<vector<int>> values;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        int height = matrix.size();
        if (height == 0){
            return;
        }
        int width = matrix[0].size();
        if (width == 0){
            return;
        }
        values = vector<vector<int>> (height, vector<int>(width, 0));
        root = new segtree;
        root -> col1 = 0;
        root -> col2 = width-1;
        root -> row1 = 0;
        root -> row2 = height - 1;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    void update(int row, int col, int val){
        int diff = val - values[row][col];
        values[row][col] = val;
        root -> update(row, col, diff);
    }

    int sumRegion(int row1, int col1, int row2, int col2){
        return root -> query(row1, row2, col1, col2);
    }
};

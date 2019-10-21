//
// Created by Shaoze Wang on 10/20/19.
//

#include <vector>
#include <stdio.h>
#include <stack>

using namespace std;
/* TODO
 * build BIT ops
 * */

void update(vector<int> &, int, int);
int find(vector<int> &, int);

void update(vector<int> &tree, int index, int val){
    int cur = index, size = tree.size();
    while(cur < size){
        tree[cur] += val;
        cur += cur & (-cur);
    }
}

int find(vector<int> &tree, int index){
    int cur = index, amount = 0;
    while(cur > 0){
        amount += tree[cur];
        cur -= cur & (-cur);
    }
    return amount;
}

int main(){
    int num_branch, num_query, i=0;
    scanf("%d", &num_branch);
    vector<vector<int>>tree (num_branch+1);
    while(++i<num_branch){
        int a, b;
        scanf(" %d %d", &a, &b);
        tree[a].push_back(b);
        tree[b].push_back(a);
    }
    vector<int> dfs(num_branch+1, 0), cross(num_branch+1, 0), apple(num_branch+1, 1);
    stack<int> stk;
    int counter = 0;
    stk.push(1);
    while(!stk.empty()){
        int cur = stk.top();
        stk.pop();
        if (cross[cur]){
            continue;
        }
        cross[cur] =  num_branch - counter;
        counter++;
        if (!stk.empty()){
            dfs[cur] = stk.top();
        }
        //printf("%d: %d until %d\n", cur, cross[cur], dfs[cur]);
        vector<int> & children = tree[cur];
        for (int i=0; i<children.size(); i++){
            if (!cross[children[i]]){
                stk.push(children[i]);
            }
        }
    }
    vector<int> bit(num_branch+1, 0);
    for (int i=1; i<num_branch+1; i++){
        update(bit, cross[i], apple[i]);
    }
    scanf("%d", &num_query);
    i = 0;
    while(i++ < num_query){
        char cmd;
        int index;
        scanf(" %c %d", &cmd, &index);
        if (cmd == 'C'){
            apple[index] = -apple[index];
            update(bit, cross[index], apple[index]);
        }else{
            int a = find(bit, cross[index]), b = find(bit, cross[dfs[index]]);
            printf("%d\n", a-b);
        }
    }
}
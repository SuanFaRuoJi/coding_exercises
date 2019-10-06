//
// Created by Shaoze Wang on 10/5/19.
//

#include "wsz_cpp_pq.h"



class Solution {
public:
    class comp_func{
    public:
        bool operator() (pair<int, int>& l, pair<int, int>& r){
            return l < r;
        }
    };

    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, comp_func> q; // height first, right second for sorting purpose
        vector<vector<int>> result;
        for (int i=0; i<buildings.size(); i++){
//cout << i << endl;
            vector<int> to_push = buildings[i];
            int height = to_push[2];
            int right = to_push[1];
            int left = to_push[0];
            if (!q.empty()){
                pair<int, int> cur = (q.top());
//cout << "cur: " << cur.first << " " << cur.second << endl;
                while(!q.empty() && q.top().second < left){
                    q.pop();
//cout << "pop: " << q.top().first << " " << q.top().second << endl;
                    if (q.empty()){
                        result.push_back(vector<int>{cur.second, 0});
                        break;
                    }
                    if (q.top().second > cur.second){
//cout << "found" << endl;
                        result.push_back(vector<int> {cur.second, q.top().first});
                        cur = (q.top());
                    }
                }
            }
            pair<int, int> push_pair (height, right);
            if (q.empty() || q.top().first < height){
                if (!result.empty()){
                    vector<int> prev = result[result.size()-1];
                    if (prev[0] == left && prev[1] < height){
                        result.pop_back();
                    }
                }
                result.push_back(vector<int> {left, height});
            }
            q.push(push_pair);
        }
        if (!q.empty()){
            pair<int, int> cur = (q.top());
            while(!q.empty()){
                q.pop();
                if (q.empty()){
                    result.push_back(vector<int>{cur.second, 0});
                    break;
                }
                if (q.top().second > cur.second){
                    result.push_back(vector<int> {cur.second, q.top().first});
                    cur = (q.top());
                }
            }
        }
        return result;
    }
};
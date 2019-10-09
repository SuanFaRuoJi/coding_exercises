//
// Created by Shaoze Wang on 10/5/19.
//

#include "wsz_cpp.h"

class Solution {
public:
    struct pair_hash {
        template <class T1, class T2>
        size_t operator()(const pair<T1, T2>& p) const
        {
            auto hash1 = hash<T1>{}(p.first);
            auto hash2 = hash<T2>{}(p.second);
            return hash1 ^ hash2;
        }
    };

    int recursion(unordered_set<pair<int, int>, pair_hash>& cur, int cat, int mouse, vector<vector<int>>& graph, vector<vector<int>> dp, int depth){
        cout << "Checking " << mouse << " " << cat << endl;
        vector<int> mouse_steps = graph[mouse], cat_steps = graph[cat];
        int result = 0;
        if (dp[mouse][cat] != -2){
            return dp[mouse][cat];
        }
        if (depth >= graph.size() * 2){
            dp[mouse][cat] = 0;
            return 0;
        }
        for (int i=0; i<mouse_steps.size(); i++){
            if (mouse_steps[i] == 0){
                dp[mouse][cat] = -1;
                cout << "Result for "<< mouse << " " << cat << ": " << -1 << endl;
                return -1;
            }
            if (mouse_steps[i] == cat){
                continue;
            }
            int this_result = -2; // mouse chooses this step
            cout << "Mouse choose " << mouse_steps[i] << endl;
            for (int j=0; j<cat_steps.size(); j++) {

                pair<int, int> next_step(mouse_steps[i], cat_steps[j]);
                if (cat_steps[j] != 0){
                    if (cur.find(next_step)!=cur.end()){
                        this_result = max(this_result, 0);
                    }else{
                        cout << "Cat choose " << cat_steps[j] << endl;
                        cur.insert(next_step);
                        int step_result = recursion(cur, cat_steps[j], mouse_steps[i], graph, dp);
                        cur.erase(next_step);
                        if (step_result == 1){ // cat has a way to win, then cat will always choose this way
                            this_result = 1;
                            break;
                        }
                        this_result = max(this_result, step_result); // otherwise cat maximizes on this path
                    }
                }
            }
            cout << "Result for mouse choosing  "<< mouse_steps[i] << ": " << this_result << endl;
            if (this_result == -1){
                /*
                 * == 1: cat can win if mouse chooses this way
                 * == -1: mouse can win if mouse chooses this way, then mouse will always choose this way, short circuit
                 * == 0: this way is a draw, keep looking
                 * */
                dp[mouse][cat] = -1;
                cout << "Resule for " << mouse << " " << cat << ": " << -1 << endl;
                return -1;
            }
            if (this_result == -2){
                this_result = 0;
            }
            result = min(result, this_result); // otherwise mouse maximizes on all possible path
        }
        cout << "Resule for " << mouse << " " << cat << ": " << result << endl;
        dp[mouse][cat] = result;
        return result;
    }

    int catMouseGame(vector<vector<int>>& graph) {
        /*
         * TODO seed the dp table.
         * */
        int l = graph.size();
        vector<vector<int>> dp (l, vector<int>(l, -2));
        for (int i=0; i<l; i++){
            dp[0][i] = -1;
        }
        for (int i=1; i<l; i++){
            dp[i][i] = 1;
        }
        unordered_set<pair<int, int>, pair_hash> path;
        path.insert(pair<int, int>(1,2));
        int result = recursion(path, 2, 1, graph, dp);
        if (result == 1){
            return 2;
        }
        if (result == -1){
            return 1;
        }
        return result;
    }
};
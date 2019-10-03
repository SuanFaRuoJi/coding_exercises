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
        vector<vector<int> > map;
        int index = 0;
        for (auto i = nums.begin(); i != nums.end(); ++i){
            vector<int> to_add {*i, index++, 0};
            map.push_back(to_add);
        }
        auto raw_result = recursion(map, 0, nums.size()-1);

        return to_vector(raw_result);
    }

    vector<int> to_vector(vector<vector<int> >& map){
        vector<int> result (map.size());
        for (auto i = map.begin(); i != map.end(); ++i){
            vector<int> cur = *i;
            result[cur[1]] = cur[2];
        }
        return result;
    }

    vector<vector<int> >& recursion(vector<vector<int> >& map, int l, int r){

        int length = r-l+1;
        if (length == 1) {
            vector<vector<int> >* result = new vector<vector<int> > {map[l]};
            return *result;
        }
        if (length == 2){
            vector<vector<int> >* result;
            int a = map[l][0], b = map[r][0];
            if (a > b){
                map[l][2] += 1;
                result = new vector<vector<int> > {map[r], map[l]};
            }
            else{
                result = new vector<vector<int> > {map[l], map[r]};
            }
            return *result;
        }
        int mid = (l+r)/2, amount = 0;
        auto front = recursion(map, l, mid), back = recursion(map, mid+1, r);
        auto front_it = front.begin(), back_it = back.begin();
        /*
        for (; front_it != front.end(); front_it++){
            cout << "front:" << (*front_it)[0] << " " << (*front_it)[1] << " " << (*front_it)[2] << endl;
        }
        for (; back_it != back.end(); back_it++){
            cout << "back:" << (*back_it)[0] << " " << (*back_it)[1] << " " << (*back_it)[2] << endl;
        }
         */
        front_it = front.begin();
        back_it = back.begin();
        //cout << l << " " << r << endl;
        vector<vector<int> >* result = new vector<vector<int> > ();
        while(front_it != front.end() || back_it != back.end()){
            while(back_it != back.end() && (front_it == front.end() || (*back_it)[0] < (*front_it)[0])){
                amount ++;
                result->push_back((*back_it));
                //cout << "back:" << (*back_it)[0] << " " << (*back_it)[1] << " " << (*back_it)[2] << endl;
                back_it ++;
            }
            //cout << "next" << endl;
            while(front_it != front.end() && (back_it == back.end() || (*front_it)[0] <= (*back_it)[0])){
                (*front_it)[2] += amount;
                result->push_back((*front_it));
                //cout << "front:" << (*front_it)[0] << " " << (*front_it)[1] << " " << (*front_it)[2] << endl;
                front_it ++;
            }
        }
        return *result;
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
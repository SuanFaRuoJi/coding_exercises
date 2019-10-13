//
// Created by Shaoze Wang on 10/12/19.
//

using namespace std;

class comp_func{
    bool operator() (const pair<Interval*, int> &a, const pair<Interval*, int> &b){
        return a.first->start > b.first->start;
    }
};

class wsz_cpp_pq {
public:
    vector<Interval*> employeeFreeTime(vector<vector<Interval*>> schedule) {
        int num_emp = schedule.size();
        priority_queue<pair<Interval *, int>, vector<pair<Interval *, int>>, comp_func> q;
        vector<int> record(num_emp, 1);
        for (int i=0; i<num_emp; i++){
            q.push(pair<Interval *, int>(schedule[i][0], i));
            //cout << "employee "<< i << ":" << schedule[i].size() << endl;
        }
        vector<Interval *> result;
        int max_end = 0;
        while(!q.empty()){
            //cout << schedule[0].size() << endl;
            const pair<Interval *, int> &cur = q.top();
            //cout << cur.first->start << " " << cur.first->end << ": " << cur.second << endl;
            int index = cur.second;
            Interval * cur_interv = cur.first;
            if (cur_interv->start > max_end){
                if (max_end != 0){
                    result.push_back(new Interval(max_end, cur_interv->start));
                }
            }
            max_end =  max(max_end, cur_interv->end);
            //cout << index << " at index: " << record[index] << " out of " << schedule[index].size() << endl;
            q.pop();
            if (record[index] < schedule[index].size()){
                q.push(pair<Interval*, int>(schedule[index][record[index]], index));
                record[index] += 1;
            }
        }
        return result;
    }
};
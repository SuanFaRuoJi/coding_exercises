//
// Created by Shaoze Wang on 1/21/21.
// https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=698
//

#include <iostream>
#include <stdio.h>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

void fill(int * arr, int length);
void print(int * arr, int length);
int * calculate(int * init_fish, int * dec_fish, int up_to, int time, int lakes);

int main()
{
    int lakes, i;
    cin >> lakes;
    while (lakes != 0) {
        int time_h;
        i ++;
        cin >> time_h;
        int init_fish[lakes], dec_fish[lakes], dist[lakes-1];
        fill(init_fish, lakes);
        fill(dec_fish, lakes);
        fill(dist, lakes-1);
        int time_5m = time_h * 12, up_to = 0;
        int * max = nullptr;
        while (time_5m > 0 && up_to < lakes) {
            int * local = calculate(init_fish, dec_fish, up_to, time_5m, lakes);
            // print(local, lakes+1);
            if (max == nullptr || local[lakes] > max[lakes]) {
                max = local;
            }
            time_5m -= dist[up_to++];
        }
        if (i != 1) {
            cout << endl;
        }
        print(max, lakes);
        cout << "Number of fish expected: " << max[lakes] << endl;
        cin >> lakes;
    }
    return 0;
}

void fill(int * arr, int length) {
    for (int i=0; i<length; i++) {
        cin >> arr[i];
    }
}

void print(int * arr, int length) {
    for (int i=0; i<length; i++) {
        if (i != 0) {
            cout << ", ";
        }
        cout << arr[i];
    }
    cout << endl;
}

class Lake {
public:
    int cur, dec, index;
    Lake(int init, int _dec, int _index) {
        cur = init;
        dec = _dec;
        index = _index;
    }

    bool operator<(Lake other) const
    {
        return cur == other.cur ? (index > other.index) : (cur < other.cur);
    }

    friend ostream& operator<<(ostream& os, const Lake& lake) {
        os << "Lake " << lake.index <<": " << lake.cur << ", " << lake.dec << endl;
        return os;
    }
};

int * calculate(int * init_fish, int * dec_fish, int up_to, int time, int lakes) {
    int * local = new int[lakes+1];
    fill(local, local + lakes, 0);

    priority_queue<Lake, vector<Lake>> pq;
    for (int i=0; i<=up_to; i++) {
        pq.push(Lake(init_fish[i], dec_fish[i], i));
    }

    int sum = 0;
    while (!pq.empty() && time > 0) {
        const Lake& cur = pq.top();
        // cout << cur;
        local[cur.index] += 5;
        sum += cur.cur;
        Lake next(max(cur.cur-cur.dec, 0), cur.dec, cur.index);
        // cout << next;
        pq.pop();
        if (next.cur >= 0) {
            pq.push(next);
        }
        time --;
    }
    local[0] += time * 5;
    local[lakes] = sum;
    return local;
}
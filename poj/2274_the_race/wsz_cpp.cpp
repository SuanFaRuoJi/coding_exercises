//
// Created by Shaoze Wang on 10/11/19.
//

#include <stdio.h>
#include <queue>
#include <vector>

using namespace std;

struct car{
    int position;
    int index;
    car * next; // use index
    car * before;
    int velocity;
};
typedef struct car car;

int bit[102];
void update(int velocity){
    int index = velocity + 1;
    while(index < 102){
        bit[index] ++;
        index += index & (-index);
    }
}

int find(int velocity){
    int index = velocity, amount = 0;
    while(index){
        amount += bit[index];
        index -= index & (-index);
    }
    return amount;
}

struct priority_func{
    bool operator() (const car &a, const car &b){
        printf("Compare %d %d\n", a.index, b.index);
        if (a.next && b.next){
            int a_distance = a.next->position - a.position, b_distance = b.next->position - b.position;
            int a_velocity = a.velocity - a.next->velocity, b_velocity = b.velocity - b.next->velocity;
            if (a_velocity > 0 && b_velocity > 0){
                int difference = a_distance*b_velocity - b_distance*a_velocity;
                if (difference){
                    return difference > 0;
                }
                return a.position > b.position;
            }
            if (a_velocity > 0){
                return false;
            }
            if (b_velocity > 0){
                return true;
            }
            return true;
        }
        if (a.next){
            return true; // a can pass, b can't, a goes first
        }
        if (b.next){
            return false;
        }
        return true;
    }
};

int main(){
    /*
     * Read input, do BIT update, ordered by position, value by speed.
     * Meanwhile, add values into PQ, pair<car, fraction>
     * */
    int size, amount = 0, i = 0;
    scanf("%d", &size);
    car * prev;
    priority_queue<car, vector<car>, priority_func> q;
    while(i<size){
        car cur;
        cur.index = i+1;
        scanf("%d %d", &(cur.position), &(cur.velocity));
        amount += i - find(cur.velocity+1); // plus 1 to get everything before and <= in velocity, minus it to get all passing
        update(cur.velocity);
        if (prev){
            prev->next = &cur;
            cur.before = prev;
            //q.push(*prev); TODO think about no-deletion, check feasibility.
        }
        prev = &cur;
        i++;
    }
    q.push(*prev);
    printf("%d %d\n", amount, q.size());
    while(!q.empty()){
        car cur = q.top();
        q.pop();
        printf("%d\n", cur.index);
        if (!(cur.next && cur.velocity > cur.next->velocity)){
            break;
        }
        printf("%d %d\n", cur.index, cur.next->index);
        car * c_next = cur.next, * c_before = cur.before;
        cur.next = c_next->next;
        c_next->next = &cur;
        cur.before = c_next;
        c_before->next = c_next;
        q.push(cur);
    }
}


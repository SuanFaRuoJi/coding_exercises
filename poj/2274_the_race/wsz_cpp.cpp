//
// Created by Shaoze Wang on 10/11/19.
//

#include <stdio.h>
#include <queue>
#include <vector>
#include <iostream>

using namespace std;

struct car{
    int position;
    int index;
    int id;
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

bool earlier(car * a, car * b){ // strictly <
    /* First check null. If a is null, return true. If b is null, return false
     * Then check next car. If a->next is null, return true. If b->next is null, return false
     * Then check speed diff, if a->speed diff <= 0, return true. If b->speed diff <= 0, return false
     * Then check time using product, if not equal, return l < r
     * If equal, return a,b distance / a,b speed diff and a, a.next distance / a, a.next speed diff using product
     */
    if (!a){
        return false;
    }
    if (!b){
        return true;
    }

    if (!(a->next)){
        return false;
    }
    if (!(b->next)){
        return true;
    }

    //cout << "Comparing " << a->id << " " << a->next->id << " and " << b->id << " " << b->next->id << endl;

    int a_speed = a->velocity - a->next->velocity, b_speed = b->velocity - b->next->velocity;
    if (a_speed <= 0){
        return false;
    }
    if (b_speed <= 0){
        return true;
    }

    double a_time = (a->next->position - a->position) / (double)(a_speed);
    double b_time = (b->next->position - b->position) / (double)(b_speed);
    if (a_time != b_time){
        return a_time < b_time;
    }
    double a_position = a->position + a_time * a->velocity, b_position = b->position + b_time * b->velocity;
    //cout << a_position << " " << b_position << endl;
    return a_position < b_position;
}

car *pq[250001];
void traverse(int index, int size){
    int cur = index;

    while(cur<=size){
        int to_exchange = cur;
        if (cur*2 <= size && earlier(pq[cur*2], pq[to_exchange])){
            to_exchange = cur*2;
        }
        if (cur*2+1 <= size && earlier(pq[cur*2+1], pq[to_exchange])){
            to_exchange = cur*2 + 1;
        }
        if (to_exchange != cur){
            // exchange indices
            int tmp_index = pq[cur]->index;
            pq[cur]->index = pq[to_exchange]->index;
            pq[to_exchange]->index = tmp_index;

            // exchange pointers
            car * tmp = pq[cur];
            pq[cur] = pq[to_exchange];
            pq[to_exchange] = tmp;

            cur = to_exchange;
        }else{
            break;
        }
    }
}

void build_heap(int size){
    for (int i=size/2; i>=1; i--){
        traverse(i, size);
    }
}

void update(int index, int size){
    /*
     * The key point here is that whenever a key is updated, it means the car before it is changed,
     * i.e., the car previously closest in front of it passed a car, therefore the updated time will always be
     * at least the same as the previous time, thus enabling the update.
     * Here the value update has been completed, only need to bubble up
     * */
    int cur = index;
    while(cur>1){
        car * elem = pq[cur], * parent = pq[cur/2];
        if (earlier(elem, parent)){
            // exchange indices
            int tmp_index = elem->index;
            elem->index = parent->index;
            parent->index = tmp_index;

            // exchange pointers, must use random access
            car * tmp = pq[cur];
            pq[cur] = pq[cur/2];
            pq[cur/2] = tmp;
        }else{
            break;
        }
        cur /= 2;
    }
}

void add(car * to_add, int size){
    //cout << "add" << endl;
    pq[size+1] = to_add;
    pq[size+1]->index = size+1;
    update(size+1, size+1);
}

car* offer(int size){
    //cout << "offer" << endl;
    if (size == 0){
        return 0;
    }
    car * to_ret = pq[1];

    pq[1] = pq[size];
    pq[1]->index = 1;
    pq[size] = 0;
    size --;

    traverse(1, size);
    return to_ret;
}

void inspect(int size){
    cerr << "Current pq" << endl;
    for (int i=1; i<=size; i++){
        car * cur = pq[i];
        cerr << cur->id << " at " << cur->index;
        if (cur->next){
            cerr << " " << cur->next->id << ": " << cur->next->position-cur->position << "/" << cur->velocity-cur->next->velocity;
        }
        cerr << endl;
    }
    cerr << "Finished" << endl;
}

int main(){
    /*
     * Read input, do BIT update, ordered by position, value by speed.
     * Meanwhile, add values into PQ, pair<car, fraction>
     * */
    int size, i = 0;
    long long amount = 0;
    scanf("%d", &size);
    if (size == 0){
        printf("0\n");
        return 0;
    }
    car * prev;
    while(i<size){
        car * cur = new car();
        cur->id = i+1;
        scanf("%d %d", &(cur->position), &(cur->velocity));
        amount += i - find(cur->velocity+1); // plus 1 to get everything before and <= in velocity, minus it to get all passing
        update(cur->velocity);
        if (prev) {
            prev->next = cur;
            cur->before = prev;
            pq[i] = prev;
            prev->index = i;
        }
        //inspect(i);
        prev = cur;
        i++;
    }
    //cout << prev->id << endl;
    pq[size] = prev;
    prev->index = size;
    build_heap(size);
    printf("%d\n", (int)(amount%1000000));
    //inspect(size);
    /* need to change:
     * next of cur -> next of next of cur
     * prev of next of cur -> cur
     * next of prev of cur -> next
     * next of next of cur -> cur
     */

    if (amount == 0){
        return 0;
    }
    int limit = 10000;
    //inspect(size);
    while(amount && limit){
        car * cur = offer(size);
        //printf("%d\n", cur->id);
        size --;
        if (!(cur->next) || cur->velocity <= cur->next->velocity){
            break;
        }
        //float time = (cur->next->position-cur->position)/(float)(cur->velocity-cur->next->velocity);
        //float position = cur->position + time * cur->velocity;
        //fprintf(stderr, "%d %d %f %f\n", cur->id, cur->next->id, time, position);
        fprintf(stdout, "%d %d\n", cur->id, cur->next->id);
        limit --;
        amount --;
        car * ori_next = cur->next, * ori_before = cur->before; // better to keep these two pointers fixed.
        cur->before = ori_next;
        cur->next = ori_next->next;

        if (cur->next){
            cur->next->before = cur;
        }

        ori_next->next = cur;
        ori_next->before = ori_before;

        if (ori_before){
            ori_before->next = ori_next;
            update(ori_before->index, size);
        }

        traverse(ori_next->index, size);
        //inspect(size);
        add(cur, size);
        size++;
        //inspect(size);
    }
}


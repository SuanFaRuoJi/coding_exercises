//
// Created by Shaoze Wang on 10/29/19.
//

#include "wsz_ite.h"

class Node {
public:
    int val;
    Node * left;
    Node * right;

    Node() {}

    Node(int _val, Node * _left, Node * _right){
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
public:
    Node * treeToDoublyList(Node * root){
        if (!root){
            return 0;
        }
        Node * left_head = treeToDoublyList(root->left), * right_head = treeToDoublyList(root->right), right_tail;
        if (left_head){
            Node * left_tail = left_head->left;
            root->left = left_tail;
            left_tail->right = root;
        }else{
            left_head = root;
        }
        if (right_head){
            root->right = right_head;
            right_head->left = root;
            right_tail = right_head->left;
        }else{
            right_tail = root;
        }
        left_head->left = right_tail;
        right_tail->right = left_head;
        return left_head;
    }
};
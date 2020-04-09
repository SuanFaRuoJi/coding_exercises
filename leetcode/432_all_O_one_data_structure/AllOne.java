import java.util.HashMap;
import java.util.HashSet;

public class AllOne {
    LinkedList head, tail;
    HashMap<String, LinkedList> reference;

    class LinkedList {
        LinkedList next, prev;
        int val, count;
    }

    /** Initialize your data structure here. */
    public AllOne() {
        head = null;
        tail = null;
        reference = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (reference.containsKey(key)) {

        } else {

        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return null;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return null;
    }

    private void insert(LinkedList pos, int val) {
        if (pos.next == null) {
            LinkedList to_insert = new LinkedList();
            to_insert.val = val;
            to_insert.count = 1;
            to_insert.prev = pos;
            to_insert.next = null;
            pos.next = to_insert;
            tail = to_insert;
            if (head == null) {
                head = to_insert;
            }
        } else {
            if (pos.next.val == val) {
                pos.next.count ++;
            } else {
                LinkedList to_insert = new LinkedList();
                to_insert.val = val;
                to_insert.count = 1;
                to_insert.prev = pos;
                to_insert.next = pos.next;
                pos.next = to_insert;
            }
        }
    }

    private void delete(LinkedList pos) {

        if (pos == head) {
            if (pos.next != null) {
                pos.next.prev = null;
            }
            head = pos.next;
        }
        if (pos == tail) {
            if (pos.prev != null) {
                pos.prev.next = null;
            }
            tail = null;
        }
        LinkedList next = pos.next;
        pos.prev.next = next;
        next.prev = pos.prev;
    }
}

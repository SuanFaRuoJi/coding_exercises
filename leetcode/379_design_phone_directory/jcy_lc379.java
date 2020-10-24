public class jcy_lc379 {
    int[] next;
    int idx;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public jcy_lc379(int maxNumbers) {
        next = new int[maxNumbers];
        for (int i = 0; i < maxNumbers; i++)
            next[i] = (i + 1) % maxNumbers;
        idx = 0;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (next[idx] == -1) return -1;
        int res = idx;
        idx = next[idx];
        next[res] = -1;
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return next[number] != -1;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (next[number] == -1) {
            next[number] = idx;
            idx = number;
        }
    }
}
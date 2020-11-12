public class jcy_lc277 extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        if (celebrity(candidate, n)) return candidate;
        return -1;
    }

    private boolean celebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (knows(i, j) || !knows(j, i)) return false;
        }
        return true;
    }
}
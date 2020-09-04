public class jcy_lc470 extends SolBase {
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = (col - 1) + (row - 1) * 7;
        } while (idx >= 40);
        return idx % 10 + 1;
    }
}

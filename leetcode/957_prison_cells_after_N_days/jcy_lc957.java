import java.util.*;

public class jcy_lc957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();
        boolean cycle = false;
        int len = 0;
        while (N > 0) {
            if (!cycle) {
                String key = Arrays.toString(cells);
                if (seen.containsKey(key)) {
                    N %= seen.get(key) - N;
                    cycle = true;
                } else {
                    seen.put(key, N);
                }
            }
            if (N > 0) {
                cells = nextDay(cells);
                N -= 1;
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < 7; i++)
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return next;
    }
}

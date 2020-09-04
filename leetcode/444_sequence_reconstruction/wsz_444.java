import java.util.ArrayList;
import java.util.List;

public class wsz_444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0) {
            return false;
        }
        int length = org.length;
        int[][] degrees = new int[length+1][3];
        List<Integer>[] out_edges = new List[length+1];
        for (List<Integer> part : seqs) {
            int from = -1;
            for (int to : part) {
                if (to > length || to <= 0) {
                    return false;
                }
                degrees[to][2] = 1;
                if (from != -1) {
                    degrees[from][0] ++;
                    degrees[to][1] ++;
                    if (out_edges[from] == null) {
                        out_edges[from] = new ArrayList<>();
                    }
                    out_edges[from].add(to);
                }
                from = to;
            }
        }
        int cur = -1;
        for (int i=1; i<=length; i++) {
            if (degrees[i][1] == 0 && degrees[i][2] == 1) { // a source
                if (cur != -1) {
                    return false;
                }
                cur = i;
            }
        }
        if (cur != org[0]) {
            return false;
        }
        int cur_index = 1;
        while (cur_index < length) {
            int prev = cur;
            cur = -1;
            if (degrees[prev][0] == 0) {
                return false;
            }
            for (int neighbor : out_edges[prev]) {
                degrees[neighbor][1] --;
                if (degrees[neighbor][1] == 0) {
                    if (cur != -1) {
                        return false;
                    }
                    cur = neighbor;
                }
            }
            if (cur != org[cur_index]) {
                return false;
            }

            cur_index ++;
        }
        return cur_index == length;
    }
}

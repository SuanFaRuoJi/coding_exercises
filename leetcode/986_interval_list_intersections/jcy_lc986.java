import java.util.ArrayList;
import java.util.List;

public class jcy_lc986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left <= right) list.add(new int[]{left, right});
            if (A[i][1] < B[j][1]) i += 1;
            else j += 1;
        }
        int[][] res = new int[list.size()][2];
        for (int idx = 0; idx < list.size(); idx++) res[idx] = list.get(idx);
        return res;
    }
}
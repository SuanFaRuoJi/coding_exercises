public class lc_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[][] counter = new int[7][3];
        int l = A.length;
        if (l == 0) {
            return 0;
        }
        boolean able = false;
        for (int i=0; i<l; i++) {
            if (A[i] == B[i]) {
                counter[A[i]][0] += 1;
                counter[A[i]][1] += 1;
                counter[A[i]][2] += 1;
            } else {
                counter[A[i]][0] += 1;
                counter[A[i]][1] += 1;
                counter[B[i]][0] += 1;
                counter[B[i]][2] += 1;
            }
            if (counter[A[i]][0] == l || counter[B[i]][0] == l) {
                return Math.min(l-counter[A[i]][1], l-counter[B[i]][2]);
            }
        }
        return -1;
    }
}

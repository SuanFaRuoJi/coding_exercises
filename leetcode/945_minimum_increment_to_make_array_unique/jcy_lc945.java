public class jcy_lc945 {
    public int minIncrementForUnique(int[] A) {
        int freq[] = new int[100000];
        for (int i : A) freq[i] += 1;
        int res = 0;
        for (int i = 0; i < 100000; i++) {
            if (freq[i] >= 2) {
                res += freq[i] - 1;
                freq[i + 1] += freq[i] - 1;
            }
        }
        return res;
    }
}
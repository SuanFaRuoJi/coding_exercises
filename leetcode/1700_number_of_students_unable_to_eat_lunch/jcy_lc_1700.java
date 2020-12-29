public class jcy_lc_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[]{0, 0};
        int n = students.length, k = 0;
        for (int s : students) cnt[s] += 1;
        while (k < n) {
            if (cnt[sandwiches[k]] > 0) cnt[sandwiches[k]] -= 1;
            else break;
            k += 1;
        }
        return n - k;
    }
}
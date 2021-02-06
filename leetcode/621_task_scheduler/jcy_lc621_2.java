public class jcy_lc621_2 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int t : tasks) freq[t - 'A'] += 1;
        int maxFreq = 0;
        for (int f : freq) maxFreq = Math.max(maxFreq, f);
        int maxCnt = 0;
        for (int f : freq) if (f == maxFreq) maxCnt += 1;
        return Math.max(tasks.length, (n + 1) * (maxFreq - 1) + maxCnt);
    }
}
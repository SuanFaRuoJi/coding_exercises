import java.util.Arrays;

public class jcy_lc621_1 {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char t : tasks) frequencies[t - 'A'] += 1;
        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleTime = (maxFreq - 1) * n;
        for (int i = frequencies.length - 2; i >= 0; i--)
            idleTime -= Math.min(frequencies[i], maxFreq - 1);
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
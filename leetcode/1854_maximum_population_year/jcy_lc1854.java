public class jcy_lc1854 {
    public int maximumPopulation(int[][] logs) {
        int[] count = new int[101];
        for (int[] log : logs)
            for (int i = log[0]; i < log[1]; i++)
                count[i - 1950] += 1;
        int maxPopulation = 0, res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxPopulation) {
                maxPopulation = count[i];
                res = i + 1950;
            }
        }
        return res;
    }
}
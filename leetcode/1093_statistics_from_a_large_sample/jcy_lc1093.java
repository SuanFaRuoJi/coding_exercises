public class jcy_lc1093 {
    public double[] sampleStats(int[] count) {
        int total = 0, mode = 0;
        double median = 0, min = -1, max = 0, average = 0, sum = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                total += count[i];
                if (min < 0) min = i;
                max = i;
                sum += i * count[i];
                if (count[i] > count[mode]) mode = i;
            }
        }
        average = sum / total;
        if (total == 1) median = sum;
        int m1 = (total + 1) / 2, m2 = total / 2 + 1;
        int curCnt = 0;
        for (int i = 0; i < 256; i++) {
            if (curCnt < m1 && curCnt + count[i] >= m1)
                median += i / 2.0;
            if (curCnt < m2 && curCnt + count[i] >= m2)
                median += i / 2.0;
            curCnt += count[i];
        }
        return new double[]{min, max, average, median, mode};
    }
}
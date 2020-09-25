public class jcy_lc904_2 {
    public int totalFruit(int[] tree) {
        int last = -1, secondLast = -1, lastCount = 0, currMax = 0, res = 0;
        for (int curr : tree) {
            if (curr == last || curr == secondLast) currMax += 1;
            else currMax = lastCount + 1;
            if (curr == last) lastCount += 1;
            else lastCount = 1;
            if (curr != last) {
                secondLast = last;
                last = curr;
            }
            res = Math.max(res, currMax);
        }
        return res;
    }
}
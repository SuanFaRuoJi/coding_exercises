public class wsz_829 {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int i=1; i<=N; i++) {
            int first = (N*2/i-i+1) / 2;
            if (first == 0) {
                break;
            }
            if ((first*2+i-1)*i/2 == N) {
                count ++;
            }
        }
        return count;
    }
}

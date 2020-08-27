public class wsz_793 {
    public int preimageSizeFZF(int K) {
        int[] pre_calc = new int[13];
        pre_calc[0] = 1;
        int msb = 0, remainder = K;
        for (int i=1; i<pre_calc.length; i++) {
            pre_calc[i] = pre_calc[i-1] * 5 + 1;
            if (pre_calc[i] >= K) {
                msb = i;
                break;
            }
        }
        for (int i=msb; i>0; i--) {
            remainder = remainder % pre_calc[i];
            if (remainder == 0) {
                return 5;
            }
            if (remainder == 5) {
                return 0;
            }
        }
        return 5;
    }
}

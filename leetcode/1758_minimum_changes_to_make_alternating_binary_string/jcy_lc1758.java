public class jcy_lc1758 {
    public int minOperations(String s) {
        int startWithZero = 0, startWithOne = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (i % 2 == 0) {
                if (num == 1) startWithZero += 1;
                else startWithOne += 1;
            } else {
                if (num == 1) startWithOne += 1;
                else startWithZero += 1;
            }
        }
        return Math.min(startWithZero, startWithOne);
    }
}
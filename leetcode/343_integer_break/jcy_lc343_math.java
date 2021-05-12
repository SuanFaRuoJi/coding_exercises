public class jcy_lc343_math {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int divisor = n / 3, remainder = n % 3;
        if (remainder == 1) {
            remainder = 4;
            divisor -= 1;
        } else if (remainder == 0) remainder = 1;
        return (int)Math.pow(3, divisor) * remainder;
    }
}
public class wsz_306 {
    public boolean isAdditiveNumber(String num) {
        long[] pre = new long[num.length()];
        long acc = 0;
        for (int i = 0; i < num.length(); i++) {
            long cur = num.charAt(i) - '0';
            acc = acc * 10 + cur;
            pre[i] = acc;
        }
        for (int i = 0; i < num.length(); i++) {
            long a = retrieve(pre, -1, i);
            if (a == -1) {
                continue;
            }
            boolean good = false;
            for (int j = i+1; j < num.length(); j++) {
                long b = retrieve(pre, i, j);
                if (b == -1) {
                    continue;
                }
                long first = a, second = b;
                System.out.println("first: " + first + ", second: " + second);
                int cur = j, next = cur + (int)Math.log10(first+second)+1;
                while (next < num.length()) {
                    long expect = first + second;
                    long actual = retrieve(pre, cur, next);
                    System.out.println("expect: " + expect + ", actual: " + actual);
                    good = true;
                    if (actual != expect) {
                        good = false;
                        break;
                    }
                    cur = next;
                    next = cur + (int)Math.log10(first + second)+1;
                    first = second;
                    second = expect;
                }
                if (good) {
                    return true;
                }
            }
        }
        return false;
    }

    private long retrieve(long[] pre, int i, int j) {
        if (i == -1) {
            return pre[j];
        }
        long val = pre[j] - (pre[i] * (long)Math.pow(10, (j-i)));
        if (j - i > 1 && val < Math.pow(10, j-i-1)) {
            return -1;
        }
        return val;
    }
}

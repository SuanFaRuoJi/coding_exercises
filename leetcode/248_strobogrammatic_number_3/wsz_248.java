import java.util.Map;

public class wsz_248 {
    private static final char[][] outlines = {
            {'0', '0'},
            {'1', '1'},
            {'6', '9'},
            {'8', '8'},
            {'9', '6'}
    };

    public int strobogrammaticInRange(String low, String high) {
        int[][] low_memory = new int[low.length() + 1][2], full_memory = new int[high.length() + 1][3];
        int[][] high_memory = new int[high.length() + 1][2];
        preprocess(high.length(), full_memory);
        for (int i = 0; i < high.length()+1; i++) {
            System.out.println(i + ": " + full_memory[i][0] + " " + full_memory[i][1] + " " + full_memory[i][2]);
        }
        int high_less = less(high, true, true, 0, high.length()-1, high_memory, full_memory);
        int low_less = less(low, false, true, 0, low.length()-1, low_memory, full_memory);
        System.out.println(high_less + " " + low_less);
        int result = (high_less + full_memory[high.length()-1][2]) - (low_less + full_memory[low.length()-1][2]);
        return result < 0 ? 0 : result;
    }

    private void preprocess(int n, int[][] memory) {
        for (int i = n; i > 0; i--) {
            full(i, true, memory);
            full(i, false, memory);
        }
        int acc = 0;
        for (int i = 1; i <= n; i++) {
            memory[i][2] = memory[i][0] + memory[i-1][2];
        }
    }

    private int full(int n, boolean first, int[][] memory) {
        if (n == 1) {
            memory[n][0] = 3;
            memory[n][1] = 3;
            return 3; // 0, 1, 8
        }

        if (n == 2) {
            memory[n][0] = 4;
            memory[n][1] = 5;
            return memory[n][first ? 0 : 1]; //11, 88, 69, 96
        }

        if (memory[n][first ? 0 : 1] != 0) {
            return memory[n][first ? 0 : 1];
        }

        if (first) {
            int result = 4 * full(n-2, false, memory);
            memory[n][0] = result;
            return result;
        } else {
            int result = 5 * full(n-2, false, memory);
            memory[n][1] = result;
            return result;
        }
    }

    private int less(String val, boolean strict, boolean first, int l, int r, int[][] memory, int[][] full_memory) { // <
        if (l == r) {
            int result = 0;
            char cur = val.charAt(l);
            if (cur > '0' || (cur == '0' && !strict)) {
                result += 1;
            }
            if (cur > '1' || (cur == '1' && !strict)) {
                result += 1;
            }
            if (cur > '8' || (cur == '8' && !strict)) {
                result += 1;
            }
            memory[l][first ? 0 : 1] = result;
            return result;
        }

        if (l == r-1) {
            int result = 0;
            for (char[] outline : outlines) {
                if (outline[0] == '0' && first) {
                    continue;
                }
                if (outline[0] < val.charAt(l) || (outline[0] == val.charAt(l) && (outline[1] < val.charAt(r) || (outline[1] == val.charAt(r) && !strict)))) {
                    result += 1;
                } else {
                    break;
                }
            }
            memory[l][first ? 0 : 1] = result;
            return result;
        }

        int result = 0;
        for (char[] outline : outlines) {
            if (outline[0] == '0' && first) {
                continue;
            }
            if (outline[0] < val.charAt(l)) { // strictly less than, can use full
                result += full_memory[r - l -1][1];
            } else if (outline[0] == val.charAt(l)) {
                result += less(val, outline[1] > val.charAt(r) || (strict && outline[1] == val.charAt(r)), false,l+1, r-1, memory, full_memory);
            }  else {
                break; // strictly larger, not acceptable
            }
        }
        memory[l][first ? 0 : 1] = result;
        System.out.println(val + " " + l + " " + result);
        return result;
    }
}

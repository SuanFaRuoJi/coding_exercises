import java.util.Arrays;

public class wsz_0901_2 {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        int[] crossed = new int[4], result = new int[4];
        if (search(A, crossed, result, 0)) {
            return String.format("%s%s:%s%s", result[0], result[1], result[2], result[3]);
        } else {
            return "";
        }
    }

    private boolean search(int[] A, int[] crossed, int[] result, int length) {
        if (!check(result, length)) {
            return false;
        }
        if (length == 4) {
            return true;
        }
        for (int i=3; i>=0; i--) {
            if (crossed[i] == 0) { // can use
                result[length] = A[i];
                crossed[i] = 1;
                if (search(A, crossed, result, length + 1)) {
                    return true;
                }
                crossed[i] = 0;
            }
        }
        return false;
    }

    private boolean check(int[] result, int length) {
        if (length == 1) {
            return result[0] <= 2;
        }
        if (length == 2) {
            return result[0]*10 + result[1] < 24;
        }
        if (length == 3) {
            return result[2] <= 6;
        }
        if (length == 4) {
            return result[2]*10 + result[3] < 60;
        }
        return true;
    }
}

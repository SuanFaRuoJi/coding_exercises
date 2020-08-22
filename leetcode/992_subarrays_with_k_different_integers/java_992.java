import java.util.HashMap;

public class java_992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        int result = 0, left = 0, next_left = -1, right = 0, next_right, diff = 0;
        int[] count = new int[A.length+1];
        while (right < A.length) {
            while (right < A.length && diff < K) {
                int cur = A[right];
                count[cur] ++;
                if (count[cur] == 1) {
                    diff ++;
                }
                right ++;
            }
            // at right, diff just equals K
            next_right = right;
            while (next_right < A.length) {
                if (count[A[next_right]] != 0) {
                    break;
                }
                next_right ++;
            }
            int prev_right = right;
            // at next_right, diff exceeds K
            while (left < right) {
                if (diff != K) {
                    break;
                }
                int cur = A[left];
                result += (next_right - right + 1);
                count[cur] --;
                if (count[cur] == 0) {
                    diff --;
                    while (right < next_right) {
                        int next = A[right];
                        count[next] ++;
                        right++;
                        if (count[next] == 1) {
                            diff ++;
                            break;
                        }
                    }
                }
                left ++;
            }
        }
        return result;
    }
}

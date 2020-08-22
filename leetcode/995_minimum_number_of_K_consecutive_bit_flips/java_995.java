import java.util.ArrayDeque;
import java.util.Queue;

public class java_995 {
    public int minKBitFlips(int[] A, int K) {
        int current = 0, l = 0, r = 0, num = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean not_zero = true;
        while (true) {
            while (current < A.length && A[current] != q.size() % 2) {
                current ++;
                while (!q.isEmpty() && q.peek() < current) {
                    q.poll();
                }
            }
            if (current < A.length) {
                if (current + K -1 >= A.length) {
                    return -1;
                }
                num ++;
                q.offer(current + K - 1);
            } else {
                break;
            }
        }

        return num;
    }
}

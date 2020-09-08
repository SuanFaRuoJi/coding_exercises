import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc487_stream {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, i = 0, j = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (j < nums.length) {
            if (nums[j] == 0) queue.offer(j);
            if (queue.size() > 1) i = queue.poll() + 1;
            res = Math.max(res, j - i + 1);
            j += 1;
        }
        return res;
    }
}
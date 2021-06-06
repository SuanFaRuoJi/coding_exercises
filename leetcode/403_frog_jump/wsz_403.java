import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class wsz_403 {
    public boolean canCross(int[] stones) {
        int length = stones.length;
        Set<Integer>[] options = new Set[length];
        int[] all_pos = new int[2001];
        for (int i=0; i<length; i++) {
            all_pos[stones[i]] = i;
        }

        options[0] = new HashSet<>();
        options[0].add(1);

        for (int i=0; i<length; i++) {
            if (options[i] == null) {
                continue;
            }
            int base = stones[i];
            for (int val : options[i]) {
                int pos = base + val;
                if (pos == stones[length-1]) {
                    return true;
                }
                int index = find(all_pos, pos);
                if (index != -1) {
                    if (options[index] == null) {
                        options[index] = new HashSet<>();
                    }
                    for (int diff = -1; diff < 2; diff ++) {
                        if (val+diff != 0) {
                            options[index].add(val+diff);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int find(int[] discrete, int needle) {
        int length = discrete.length;
        if (needle < discrete[0] || needle > discrete[length-1]) {
            return -1;
        }
        int left = 0, right = length;
        while (left < right) {
            int mid = (left+right)/2;
            if (mid > needle) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return discrete[left-1] == needle ? (left-1) : -1;
    }
}

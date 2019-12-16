import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length == 0 ) {
            return true;
        }
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i=0; i<hand.length; i++) {
            counter.compute(hand[i], (k, v) -> v==null ? 1 : v+1);
        }

        int min_arg = 0;
        while (min_arg < hand.length) {
            for (int i=0; i<W; i++) {
                int current = counter.containsKey(hand[min_arg]+i) ? counter.get(hand[min_arg]+i) : 0;
                if (current > 0) {
                    current -= 1;
                } else {
                    return false;
                }
                counter.put(hand[min_arg]+i, current);
            }
            while (min_arg < hand.length && counter.get(hand[min_arg]) == 0) {
                min_arg ++;
            }
        }
        return true;
    }
}

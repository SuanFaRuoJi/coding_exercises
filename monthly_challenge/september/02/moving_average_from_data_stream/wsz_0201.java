import java.util.ArrayDeque;
import java.util.Deque;

public class wsz_0201 implements MovingAverage {
    private int size_limit;
    private Deque<Integer> store;
    private int sum;

    public wsz_0201 (int size) {
        this.size_limit = size;
        this.store = new ArrayDeque<>();
        this.sum = 0;
    }

    @Override
    public double next(int val) {
        store.offerLast(val);
        sum += val;
        if (store.size() > size_limit) {
            sum -= store.pollFirst();
        }
        return (double) sum / (double)store.size();
    }
}

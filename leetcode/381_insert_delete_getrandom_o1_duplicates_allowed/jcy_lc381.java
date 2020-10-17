import java.util.*;

public class jcy_lc381 {
    Map<Integer, Set<Integer>> map; // Store elements -> indices
    List<Integer> list; // Store elements
    Random rand = new Random();

    /** Initialize your data structure here. */
    public jcy_lc381() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) map.put(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;
        int last = list.get(list.size() - 1);
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        list.set(idx, last);
        map.get(last).add(idx);
        map.get(last).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class jcy_lc981 {
    Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public jcy_lc981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TreeMap<Integer, String> tree = map.get(key);
        Integer res = tree.floorKey(timestamp);
        return res != null ? tree.get(res) : "";
    }
}
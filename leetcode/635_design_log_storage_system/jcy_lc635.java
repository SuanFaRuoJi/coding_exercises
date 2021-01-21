import java.util.*;

public class jcy_lc635 {
    private TreeMap<String, List<Integer>> map;
    private Map<String, Integer> indices;
    private String min = "2000:01:01:00:00:00", max = "2017:12:31:23:59:59";

    public jcy_lc635() {
        map = new TreeMap<>();
        indices = new HashMap<>();
        indices.put("Year", 4);
        indices.put("Month", 7);
        indices.put("Day", 10);
        indices.put("Hour", 13);
        indices.put("Minute", 16);
        indices.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        map.putIfAbsent(timestamp, new ArrayList<>());
        map.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        int idx = indices.get(granularity);
        String s = start.substring(0, idx) + min.substring(idx);
        String e = end.substring(0, idx) + max.substring(idx);
        List<Integer> res = new ArrayList<>();
        for (String key : map.subMap(s, true, e, true).keySet()) res.addAll(map.get(key));
        return res;
    }
}
import java.util.*;

public class jcy_lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq
                = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ?
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        for (Map.Entry<String,Integer> entry : map.entrySet()) pq.add(entry);
        List<String> res = new ArrayList<>();
        while (res.size() < k) res.add(pq.poll().getKey());
        return res;
    }
}
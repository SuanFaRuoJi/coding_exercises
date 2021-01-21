import java.util.*;

public class jcy_lc1348 {
    private Map<String, TreeMap<Integer, Integer>> map;

    public jcy_lc1348() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)) map.put(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        tweetMap.put(time, tweetMap.getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if (!map.containsKey(tweetName)) return null;
        List<Integer> res = new ArrayList<>();
        int interval = 0;
        if (freq.equals("minute")) interval = 60;
        else if (freq.equals("hour")) interval = 3600;
        else interval = 86400;
        int size = (endTime - startTime) / interval + 1;
        int[] buckets = new int[size];
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {
            int idx = (entry.getKey() - startTime) / interval;
            buckets[idx] += entry.getValue();
        }
        for (int n : buckets) res.add(n);
        return res;
    }
}
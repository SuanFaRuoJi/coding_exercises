import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class wsz_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginIndex = wordList.size(), endIndex = beginIndex;
        for (int i=0; i<wordList.size(); i++) {
            if (beginIndex == wordList.size() && wordList.get(i).equals(beginWord)) {
                beginIndex = i;
            }
            if (endIndex == wordList.size() && wordList.get(i).equals(endWord)) {
                endIndex = i;
            }
        }
        if (beginIndex == wordList.size()) {
            wordList.add(beginWord);
        }
        if (endIndex ==wordList.size()) {
            return 0;
        }

        HashSet<Integer>[] edges = new HashSet[wordList.size()];
        for (int i=0; i<wordList.get(0).length(); i++) {
            HashMap<String, List<Integer>> local = new HashMap<>();
            for (int j=0; j<wordList.size(); j++) {
                StringBuilder cur = new StringBuilder(wordList.get(j));
                cur.setCharAt(i, '0'); // this bit is all the same
                String key = cur.toString();
                local.putIfAbsent(key, new ArrayList<>());
                local.get(key).add(j);
            }
            for (List<Integer> set : local.values()) {
                for (int set_cur : set) {
                    if (edges[set_cur] == null) {
                        edges[set_cur] = new HashSet<>();
                    }
                    edges[set_cur].addAll(set);
                }
            }
        }

        for (int i=0; i<wordList.size(); i++) {
            System.out.println(i + ": ");
            for (int cur : edges[i]) {
                System.out.print(cur + " ");
            }
            System.out.println();
        }

        int result = 0;
        HashSet<Integer> prev = new HashSet<>(), next, used = new HashSet<>();
        prev.add(beginIndex);
        while (!prev.isEmpty()) {
            used.addAll(prev);
            result ++;
            System.out.println(result + ": ");
            next = new HashSet<>();
            for (int cur : prev) {
                System.out.print(cur + " ");
                HashSet<Integer> edge = edges[cur];
                if (edge.contains(endIndex)) {
                    return result;
                }
                next.addAll(edge.stream().filter(elem -> !used.contains(elem)).collect(Collectors.toList()));
            }
            System.out.println();
            prev = next;
        }
        return 0;
    }
}

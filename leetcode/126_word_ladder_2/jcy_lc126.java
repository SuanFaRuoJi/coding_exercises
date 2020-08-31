import java.util.*;

public class jcy_lc126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return res;
        Map<String, List<String>> map = getChildren(beginWord, endWord, words);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findPath(beginWord, endWord, map, path, res);
        return res;
    }

    private void findPath(String beginWord, String endWord, Map<String, List<String>> map, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) res.add(new ArrayList<>(path));
        if (!map.containsKey(beginWord)) return;
        for (String next : map.get(beginWord)) {
            path.add(next);
            findPath(next, endWord, map, path, res);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
        beginSet.add(beginWord); endSet.add(endWord);
        boolean found = false, back = false;
        while (!beginSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
                back = !back;
            }
            Set<String> temp = new HashSet<>();
            for (String curr : beginSet) {
                visited.add(curr);
                for (String next : getNext(curr, words)) {
                    if (visited.contains(next) || beginSet.contains(next)) continue;
                    if (endSet.contains(next)) found = true;
                    temp.add(next);
                    String parent = back ? next : curr;
                    String child = back ? curr : next;
                    map.putIfAbsent(parent, new ArrayList<>());
                    map.get(parent).add(child);
                }
            }
            beginSet = temp;
        }
        return map;
    }

    private List<String> getNext(String word, Set<String> words) {
        List<String> res = new ArrayList<>();
        char[] curr = word.toCharArray();
        for (int i = 0; i < curr.length; i++) {
            char prevChar = curr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (prevChar == c) continue;
                curr[i] = c;
                String target = String.valueOf(curr);
                if (words.contains(target)) res.add(target);
            }
            curr[i] = prevChar;
        }
        return res;
    }
}
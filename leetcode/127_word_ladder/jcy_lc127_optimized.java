import java.util.*;

public class jcy_lc127_optimized {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord); endSet.add(endWord);
        int res = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] curr = word.toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char prevChar = curr[i];
                        if (prevChar == c) continue;
                        curr[i] = c;
                        String target = String.valueOf(curr);
                        if (endSet.contains(target)) return res + 1;
                        if (words.contains(target)) {
                            temp.add(target);
                            words.remove(target);
                        }
                        curr[i] = prevChar;
                    }
                }
            }
            beginSet = temp;
            res += 1;
        }
        return 0;
    }
}
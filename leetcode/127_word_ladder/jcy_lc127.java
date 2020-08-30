import java.util.*;

public class jcy_lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char[] curr = q.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char prevChar = curr[j];
                        if (prevChar == c) continue;
                        curr[j] = c;
                        String currWord = String.valueOf(curr);
                        if (words.contains(currWord)) {
                            if (currWord.equals(endWord)) return res + 1;
                            words.remove(currWord);
                            q.offer(currWord);
                        }
                        curr[j] = prevChar;
                    }
                }
            }
            res += 1;
        }
        return 0;
    }
}
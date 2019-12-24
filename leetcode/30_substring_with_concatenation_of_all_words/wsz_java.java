import java.util.*;

public class wsz_java {
    class trie {
        int index = -1;
        trie[] children = new trie[26];

        void add(String word, int index, int cur) {
            if (cur == word.length()) {
                this.index = index;
                return;
            }
            int next = word.charAt(cur) - 'a';
            if (children[next] == null) {
                children[next] = new trie();
            }
            children[next].add(word, index, cur+1);
        }

        int get(String word, int cur, int length) {
            if (length == 0) {
                return index;
            }
            int next = word.charAt(cur) - 'a';
            return children[next] == null ? -1 : children[next].get(word, cur+1, length - 1);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int word_l = words[0].length();
        trie root = new trie();
        List<String> word_set = new ArrayList<>();
        Map<String, Integer> cross = new HashMap<>();
        int index = 0;
        for (String word : words) {
            if (!cross.containsKey(word)){
                cross.put(word, 1);
                word_set.add(word);
                root.add(word, index++, 0);
            } else {
                cross.put(word, cross.get(word)+1);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int offset = 0; offset < word_l; offset++) {
            int cursor = offset;
            List<Integer> match = new ArrayList<>();
            while (cursor < s.length()) {
                int cur_val = root.get(s, cursor, word_l);
                match.add(cur_val);
                cursor += word_l;
            }
            int l = 0, r = 0, count = 0;
            int[] hash = new int[word_set.size()];
            while (r < match.size()) {
                System.out.println(r + ": ");
                int cur = match.get(r);
                if (cur == -1) {
                    hash = new int[word_set.size()];
                    count = 0;
                    r ++;
                    l = r;
                } else {
                    hash[cur] += 1;
                    int target = cross.get(word_set.get(cur));
                    if (hash[cur] == target) {
                        count += 1;
                        if (count == words.length) {
                            answer.add(l*word_l + offset);
                        }
                    }
                    while (hash[cur] > target) {
                        int l_cur = match.get(l), l_target = cross.get(word_set.get(l_cur));
                        if (hash[l_cur] == l_target) {
                            count --;
                        }
                        hash[l_cur] --;
                        l++;
                    }
                    r ++;
                }
                for (int val : hash) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
        return answer;
    }

}

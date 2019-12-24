import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wsz_java_140 {
    private HashMap<Integer, List<String>> memory = new HashMap<>();

    class trie {
        String word = null;
        trie[] children = new trie[26];

        void add(String s, int index) {
            if (index == s.length()) {
                word = s;
                return;
            }
            int child = s.charAt(index) - 'a';
            if (children[child] == null) {
                children[child] = new trie();
            }
            children[child].add(s, index+1);
        }

        String get(String s, int index) {
            if (index == s.length()) {
                return word;
            }
            int child = s.charAt(index) - 'a';
            if (children[child] == null) {
                return null;
            }
            return children[child].get(s, index+1);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie root = new trie();
        for (String word : wordDict) {
            root.add(word, 0);
        }
        return wordBreak(s, root, 0);
    }

    private List<String> wordBreak(String s, trie root, int index) {
        if (index == s.length()) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if (memory.containsKey(index)) {
            return memory.get(index);
        }

        List<String> result = new ArrayList<>();
        trie cur = root;
        for (int i=index; i<s.length(); i++) {
            int child = s.charAt(i) - 'a';
            if (cur.children[child] == null) {
                break;
            }
            cur = cur.children[child];
            if (cur.word != null) {
                List<String> tails = wordBreak(s, root, i+1);
                for (String tail : tails) {
                    String all = cur.word + (tail=="" ? "" : " ") + tail;
                    result.add(all);
                }
            }
        }
        memory.put(index, result);
        return result;
    }
}

import java.util.*;

public class AutocompleteSystem {
    private Trie root;
    private Trie cur;
    StringBuilder word = new StringBuilder();

    class Trie {
        int hot;
        Trie[] children;
        Map<String, Integer> freq = new HashMap<>();

        Trie() {
            hot = 0;
            children = new Trie[27];
        }

        void add_word(String s, int index, int times) {
            freq.put(s, freq.containsKey(s) ? (freq.get(s)+times): times);
            System.out.println(s + " " + freq.get(s));
            if (index == s.length()) {
                return;
            }
            int child = s.charAt(index)==' ' ? 26 : s.charAt(index)-'a';
            if (children[child] == null) {
                children[child] = new Trie();
            }
            children[child].add_word(s, index+1, times);
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i=0; i<sentences.length; i++) {
            root.add_word(sentences[i], 0, times[i]);
        }
        cur = root;
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            cur = root;
            root.add_word(word.toString(), 0, 1);
            word = new StringBuilder();
            return result;
        }
        word.append(c);
        int child = c==' ' ? 26 : c-'a';
        if (cur.children[child] == null) {
            cur = new Trie();
            return result;
        }
        cur = cur.children[child];
        List<String> sorted_list = new ArrayList(cur.freq.keySet());
        sorted_list.sort((a, b) -> {
            int f_a = cur.freq.get(a), f_b = cur.freq.get(b);
            return f_a == f_b ? a.compareTo(b) : f_b - f_a;
        });
        for (int i=0; i<Math.min(3, sorted_list.size()); i++) {
            result.add(sorted_list.get(i));
        }
        return result;
    }
}


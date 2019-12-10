import java.util.ArrayList;
import java.util.List;

public class StreamChecker {
    List<Character> store = new ArrayList<>();
    Trie root = new Trie();

    class Trie {
        Trie[] children = new Trie[26];
        boolean is_word = false;

        void add_word(String word, int index) {
            if (index < 0) {
                is_word = true;
                return;
            }
            int child = word.charAt(index) - 'a';
            if (children[child] == null) {
                children[child] = new Trie();
            }
            children[child].add_word(word, index-1);
        }

        boolean query(List<Character> store, int index) {
             if (index < 0) {
                 return is_word;
             }
             if (is_word) {
                 return true;
             }
             int child = store.get(index) - 'a';
             if (children[child] == null) {
                 return false;
             }
             return children[child].query(store, index-1);
        }
    }

    public StreamChecker(String[] words) {
        for (String word : words) {
            root.add_word(word, word.length()-1);
        }
    }

    public boolean query(char letter) {
        store.add(letter);
        return root.query(store, store.size()-1);
    }
}

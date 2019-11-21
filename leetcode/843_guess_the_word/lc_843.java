import java.util.ArrayList;
import java.util.List;

public class lc_843 {
    class Master {
        int guess(String str) {
            return 1;
        }
    }

    private String query;

    public void findSecretWord(String[] wordlist, Master master) {
        String[] cur_list = wordlist;
        for (int i=0; i<10; i++) {
            ArrayList<Integer>[] list = offer(cur_list);
            int index = master.guess(query);
            if (index == query.length()) {
                return;
            }
            cur_list = form(wordlist, list[index]);
        }
    }

    private String[] form(String[] word_list, ArrayList<Integer> selection) {
        String[] result = new String[selection.size()];
        for (int i=0; i<selection.size(); i++) {
            result[i] = word_list[selection.get(i)];
        }
        return result;
    }

    private ArrayList<Integer>[] offer(String[] list) {
        int l = list.length, min = Integer.MAX_VALUE, min_arg = -1;
        ArrayList<Integer>[][] store = new ArrayList[list.length][6];
        for (int i=0; i<l; i++) {
            String cur = list[i];
            int max = Integer.MIN_VALUE;
            for (int j=0; j<l; j++) {
                if (i == j) {
                    continue;
                }
                int count = same(cur, list[j]);
                if (store[i][count] == null) {
                    store[i][count] = new ArrayList<>();
                }
                store[i][count].add(j);
                if (store[i][count].size() > max) {
                    max = store[i][count].size();
                }
            }
            if (max < min) {
                min = max;
                min_arg = i;
            }
        }
        return store[min_arg];
    }

    private int same(String a, String b) {
        int counter = 0;
        for (int i=0; i<6; i++) {
            counter += a.charAt(i)==b.charAt(i) ? 1 : 0;
        }
        return counter;
    }
}

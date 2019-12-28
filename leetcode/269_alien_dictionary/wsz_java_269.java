import java.util.*;

public class wsz_java_269 {
    class node {
        int val;
        int[] in_edges = new int[26], out_edges = new int[26];
        int in_degree = 0;

        node(int i) {
            val = i;
        }
    }

    public String alienOrder(String[] words) {
        String prev = null;
        node[] graph = new node[26];
        Set<Integer> alphabet = new HashSet<>();
        for (String word : words) {
            if (prev != null) {
                for (int i=0; i<word.length()&&i<prev.length(); i++) {
                    int a = prev.charAt(i) - 'a', b = word.charAt(i) - 'a';
                    if (a != b) {
                        if (graph[b] == null) {
                            graph[b] = new node(b);
                        }
                        if (graph[a] == null) {
                            graph[a] = new node(a);
                        }
                        graph[a].out_edges[b] = 1;
                        if (graph[b].in_edges[a] == 0) {
                            graph[b].in_degree ++;
                            graph[b].in_edges[a] = 1;
                        }
                        break;
                    }
                }
            }
            for (int i=0; i<word.length(); i++) {
                alphabet.add(word.charAt(i)-'a');
            }
            prev = word;
        }
        Deque<Integer> dag = new ArrayDeque<>();
        for (Integer letter : alphabet) {
            if (graph[letter]==null || graph[letter].in_degree==0) {
                dag.addLast(letter);
            }
        }
        int[] cross = new int[26];
        StringBuilder result = new StringBuilder();
        while(!dag.isEmpty()) {
            int cur = dag.pollFirst();
            cross[cur] = 1;
            result.append(('a'+cur));
            if (graph[cur] != null) {
                node cur_node = graph[cur];
                for (int i=0; i<26; i++) {
                    if (cur_node.out_edges[i] == 1) {
                        if (cross[i] == 1) {
                            return "";
                        }
                        graph[i].in_edges[i] = 0;
                        graph[i].in_degree --;
                        if (graph[i].in_degree == 0) {
                            dag.addLast(i);
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class jcy_lc1813_2 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekFirst().equals(dq2.peekFirst())) {
            dq1.pollFirst();
            dq2.pollFirst();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}
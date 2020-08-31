import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wsz_358 {
    public String rearrangeString(String s, int k) {
        if (s.length() <= 1) {
            return s;
        }
        int[] histogram = new int[256];
        Set<Character>[] sorted = new Set[s.length()+1];
        for (char cur : s.toCharArray()) {
            histogram[cur] ++;
            if (sorted[histogram[cur]-1] == null) {
                sorted[histogram[cur]-1] = new HashSet<>();
            }
            sorted[histogram[cur]-1].remove(cur);
            if (sorted[histogram[cur]] == null) {
                sorted[histogram[cur]] = new HashSet<>();
            }
            sorted[histogram[cur]].add(cur);
        }
        List<Character> sortedList  = new ArrayList<>();
        int longest_count = -1;
        for (int i=sorted.length-1; i>=0; i--) {
            if (sorted[i] == null) {
                continue;
            }
            if (longest_count == -1) {
                longest_count = sorted[i].size();
            }
            sortedList.addAll(sorted[i]);
        }

        int longest = histogram[sortedList.get(0)];
        int remainder = s.length() - (longest-1) * k;
        if (longest_count > remainder) {
            return "";
        }

        StringBuilder[] builder = new StringBuilder[longest];
        int index = 0;
        for (int i=0; i<sortedList.size(); i++) {
            char cur = sortedList.get(i);
            for (int j=0; j<histogram[cur]; j++) {
                if (j == longest-1) {
                    if (builder[longest-1] == null) {
                        builder[longest-1] = new StringBuilder();
                    }
                    builder[longest-1].append(cur);
                }
                else {
                    if (builder[index] == null) {
                        builder[index] = new StringBuilder();
                    }
                    builder[index].append(cur);

                    index = (index + 1) % (longest - 1);
                }
            }
        }
        StringBuilder all = new StringBuilder();
        for (StringBuilder cur : builder) {
            all.append(cur);
        }
        return all.toString();
    }
}

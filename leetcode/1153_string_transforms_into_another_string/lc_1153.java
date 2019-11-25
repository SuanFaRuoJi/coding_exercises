import java.util.ArrayList;

public class lc_1153 {
    public boolean canConvert(String str1, String str2) {
        ArrayList<Integer>[] stats = new ArrayList[26];
        int count = 0;
        int[] cross = new int[26];
        for (int i=0; i<str1.length(); i++) {
            int index = str1.charAt(i) - 'a';
            if (stats[index] == null) {
                stats[index] = new ArrayList<>();
            }
            stats[index].add(i);
        }
        for (int i=0; i<26; i++) {
            if (stats[i] == null) {
                continue;
            }
            int map = -1;
            for (int j=0; j<stats[i].size(); j++) {
                int cur = str2.charAt(stats[i].get(j));
                if (map == -1) {
                    map = cur;
                } else {
                    if (cur != map) {
                        return false;
                    }
                }
                int map_char = map - 'a';
                if (cross[map_char] == 0) {
                    count ++;
                }
                cross[map_char] ++;
            }
        }
        return count != 26;
    }
}

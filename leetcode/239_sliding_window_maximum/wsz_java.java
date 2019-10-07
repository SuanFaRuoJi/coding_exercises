public class wsz_java {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        char[] cs = s.toCharArray();
        int total = 0, sanityCheck = 0;
        int min = n, min_h = -1, min_t = -1;
        int[] count = new int[256];
        int[] cross = new int[256];
        for (int i = 0; i < m; i++) {
            cross[t.charAt(i)]++;
        }
        int head = 0, tail = 0;
        while (tail < n) {
            char cur = cs[tail];
            int needs = cross[cur];
            if (needs >= 1) {
                count[cur]++;
                if (count[cur] <= needs) {
                    total++;
                }
                while (head < tail) {
                    char prev = cs[head];
                    int prev_needs = cross[prev];
                    if (prev_needs >= 1) {
                        if (count[prev] <= prev_needs) {
                            break;
                        } else {
                            count[prev]--;
                        }
                    }
                    head++;
                }
                if (total == m) {
                    if (tail - head + 1 <= min) {
                        min = tail - head + 1;
                        min_h = head;
                        min_t = tail + 1;
                    }
                }
            }
            tail++;
        }

        if (min_h == -1) {
            return "";
        }
        return s.substring(min_h, min_t);
        }
}


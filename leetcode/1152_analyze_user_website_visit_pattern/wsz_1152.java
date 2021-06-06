import java.util.*;

public class wsz_1152 {
    private static int max = 0;
    private static String iden = null;
    private static Map<String, Integer> all_maps;

    class View {
        String user;
        int time;
        String website;
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        max = 0;
        iden = null;
        all_maps = new HashMap<>();

        int length = username.length;
        View[] all_views = new View[length];
        for (int i=0; i<length; i++) {
            all_views[i] = new View();
            all_views[i].user = username[i];
            all_views[i].time = timestamp[i];
            all_views[i].website = website[i];
        }

        Arrays.sort(all_views, (View a, View b) -> a.user.equals(b.user) ? a.user.compareTo(b.user) : a.time - b.time);

        int prev = -1;
        String prev_person = null;
        for (int i=0; i<length; i++) {
            if (!all_views[i].user.equals(prev_person)) {
                if (prev != -1) {
                    update(all_views, prev, i, new HashSet<>());
                }
                prev_person = all_views[i].user;
                prev = i;
            }
        }

        update(all_views, prev, length, new HashSet<>());

        return Arrays.asList(iden.split(","));
    }

    private static void update(View[] all_views, int from, int to, Set<String> all_occ) {
        for (int i=from; i<to; i++) {
            for (int j=i+1; j<to; j++) {
                for (int k=j+1; k<to; k++) {
                    String iden = String.format("%s,%s,%s", all_views[i].website, all_views[j].website, all_views[k].website);
                    all_occ.add(iden);
                }
            }
        }
        all_occ.forEach(seq -> {
            all_maps.put(seq, all_maps.getOrDefault(seq, 0)+1);
            int cur = all_maps.get(seq);
            if (cur > max) {
                max = cur;
                iden = seq;
            } else if (cur == max) {
                String[] cur_strings = seq.split(","), max_strings = seq.split(",");
                for (int i=0; i<3; i++) {
                    int res = cur_strings[i].compareTo(max_strings[i]);
                    if (res != 0) {
                        if (res < 0) {
                            iden = seq;
                        }
                        break;
                    }
                }
            }
        });
    }
}

import java.util.ArrayList;

public class lc_1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int l_workers = workers.length, l_bikes = bikes.length;
        ArrayList<int[]>[] buckets = new ArrayList[2000];
        for (int i=0; i<l_workers; i++) {
            int worker_x = workers[i][0], worker_y = workers[i][1];
            for (int j=0; j<l_bikes; j++) {
                int bike_x = bikes[j][0], bike_y = bikes[j][1];
                int md = Math.abs(worker_x-bike_x) + Math.abs(worker_y-bike_y);
                if (buckets[md] == null) {
                    buckets[md] = new ArrayList<>();
                }
                int[] to_add = {i, j};
                buckets[md].add(to_add);
            }
        }
        int[] result = new int[l_workers], cross_workers = new int[l_workers], cross_bikes = new int[l_bikes];
        int count = 0;
        for (int i=0; i<2000; i++) {
            ArrayList<int[]> cur_bucket = buckets[i];
            if (cur_bucket == null) {
                continue;
            }
            for (int j=0; j<cur_bucket.size(); j++) {
                int[] cur_combiniation = cur_bucket.get(j);
                System.out.println(i + " " + cur_combiniation[0] + " " + cur_combiniation[1]);
                if (cross_workers[cur_combiniation[0]] != 0 || cross_bikes[cur_combiniation[1]] != 0) {
                    continue;
                }
                result[cur_combiniation[0]] = cur_combiniation[1];
                cross_workers[cur_combiniation[0]] = 1;
                cross_bikes[cur_combiniation[1]] = 1;
                count ++;
                if (count == l_workers) {
                    break;
                }
            }
        }
        return result;
    }
}

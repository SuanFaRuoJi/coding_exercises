import java.util.Iterator;
import java.util.PriorityQueue;

public class wsz_lc973 {
    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }

        public int compareTo(Point t) {
            return (t.x * t.x + t.y * t.y) - (x*x + y*y);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        for (int[] point : points) {
            Point cur = new Point(point[0], point[1]);
            if (q.size() < K) {
                q.offer(cur);
            } else {
                Point cur_worst = q.peek();
                if (cur_worst.compareTo(cur) < 0) {
                    q.poll();
                    q.offer(cur);
                }
            }
        }
        Iterator<Point> ite = q.iterator();

        int[][] result = new int[K][2];
        int index = 0;
        while (ite.hasNext()) {
            Point cur = ite.next();
            result[index][0] = cur.x;
            result[index][1] = cur.y;
            index ++;
        }

        return result;
    }
}
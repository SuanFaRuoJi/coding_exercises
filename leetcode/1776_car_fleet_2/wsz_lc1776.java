public class wsz_lc1776 {
    public double[] getCollisionTimes(int[][] cars) {
        int length = cars.length;
        double[] result = new double[length];
        int[] stack = new int[length];
        int height = 0;

        for (int i=length-1; i>=0; i--) {
            int cur_pos = cars[i][0], cur_vel = cars[i][1];

            while (height != 0) {
                int head = stack[height - 1], head_pos = cars[head][0], head_vel = cars[head][1];
                if (head_vel < cur_vel) { // otherwise definitely head event will happen earlier
                    double cur_collision = (head_pos - cur_pos) / (double)(cur_vel - head_vel);
                    System.out.println(head + " " + result[head] + " " + Math.abs(result[head] + (double)1));
                    if (cur_collision <= result[head] || Math.abs(result[head] + (double)1) < 0.00001) {
                        result[i] = cur_collision;
                        break;
                    }
                }
                height --;
            }

            if (height == 0) {
                result[i] = -1;
            }
            stack[height++] = i;
        }

        return result;
    }
}

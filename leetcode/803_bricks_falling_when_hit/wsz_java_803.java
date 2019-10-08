import java.util.ArrayList;
import java.util.Arrays;

public class wsz_java_803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        /*
        * Essentially, this problem is asking at what time one specific brick would fall?
        * To answer this question, assume that the brick (i,j) falls at time n.
        * Then there are basically two situations:
        * a. It is hit off at time n
        * b. It is connected to another brick that falls at time n.
        * However, obviously condition b is not conclusive:
        * what if (i,j) is also connected to a brick that falls at time n+1?
        * At time n the other brick is still connected and therefore so is (i,j).
        * Therefore modification to b:
        * It is connected `at most` to another brick that falls at time n.
        * For a. What if it is only connected to bricks fall before time n? Then at time n it is already off.
        * */
        int l = hits.length, height = grid.length, width = grid[0].length;
        int[] result = new int[l];
        for (int i=0; i<l; i++){
            int x = hits[i][0], y = hits[i][1];
            grid[x][y] = grid[x][y]==1 ? i+2: 0; // mark the bricks that will be hit off.
        }
        ArrayList<int[]> q = new ArrayList<>();
        for (int i=0; i<height; i++){
            if (grid[0][i] == 1){ // seed the queue with all the unhit top level bricks
                int[] to_add = {0, i};
                grid[0][i] = 0; // change to 0 when added to avoid duplication
                q.add(to_add);
            }
        }
        search(grid, Integer.MAX_VALUE, q);
        for (int i=l-1; i>=0; i--){
            int[] cur = hits[i];
            if (grid[cur[0]][cur[1]] > 0){
                int num = search(grid, i+2, q);
                result[l] = num-1;
            }else{
                result[l] = 0;
            }
        }
        return result;
    }

    int search(int[][] grid, int iteration, ArrayList<int[]> q){
        int total = 0, height = grid.length, width = grid[0].length;
        while(!q.isEmpty()){
            total ++;
            int[] cur = q.remove(q.size()-1);
            // no need for sanity check, check at add time.
            int x = cur[0], y = cur[1], rank = grid[x][y];
            if (x+1 < height && grid[x+1][y] != 0){
                if (grid[x+1][y] == 1 || grid[x+1][y] >= iteration){
                    grid[x+1][y] = 0;
                    int[] to_add = {x+1, y};
                    q.add(to_add);
                }else{
                    grid[x+1][y] = -Math.abs(grid[x+1][y]);
                }
            }
            if (x-1 >= 0 && grid[x-1][y] != 0){
                if (grid[x-1][y] == 1 || grid[x-1][y] >= iteration){
                    grid[x-1][y] = 0;
                    int[] to_add = {x-1, y};
                    q.add(to_add);
                }else{
                    grid[x-1][y] = -Math.abs(grid[x-1][y]);
                }
            }
            if (y+1 < width && grid[x][y+1] != 0){
                if (grid[x][y+1] == 1 || grid[x][y+1] >= iteration){
                    grid[x][y+1] = 0;
                    int[] to_add = {x, y+1};
                    q.add(to_add);
                }else{
                    grid[x][y+1] = -Math.abs(grid[x][y+1]);
                }
            }
            if (y-1 < height && grid[x][y-1] != 0){
                if (grid[x][y-1] == 1 || grid[x][y-1] >= iteration){
                    grid[x][y-1] = 0;
                    int[] to_add = {x, y-1};
                    q.add(to_add);
                }else{
                    grid[x][y-1] = -Math.abs(grid[x][y-1]);
                }
            }
        }
        return total;
    }
}

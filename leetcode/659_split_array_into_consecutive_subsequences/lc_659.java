import java.util.*;

public class lc_659 {
    public boolean isPossible(int[] nums) {
        PriorityQueue<List<Integer>> progress = new PriorityQueue<>((l1, l2) -> {
            int tail_1 = l1.get(l1.size()-1), tail_2 = l2.get(l2.size()-1);
            return tail_1 == tail_2 ? l1.size() - l2.size() : tail_2 - tail_1;
        });
        int prev = -1, length = nums.length, count = 0;
        if (length == 0) {
            return true;
        }
        for (int i=0; i<length; i++) {
            int cur = nums[i];
            if (prev == -1 || cur != prev) {
                int j = 0;
                List<List<Integer>> add_back = new ArrayList<>();
                while(j < count && !progress.isEmpty()) {
                    List<Integer> offer = progress.peek();
                    if (offer.get(offer.size()-1)+1 != prev) {
                        break;
                    }
                    offer = progress.poll();
                    offer.add(prev);
                    add_back.add(offer);
                    j++;
                }
                progress.addAll(add_back);
                while (j < count) {
                    List<Integer> to_add = new ArrayList<>();
                    to_add.add(prev);
                    progress.add(to_add);
                    j++;
                }
                count = 0;
            }
            prev = cur;
            count ++;
        }
        int j = 0;
        List<List<Integer>> add_back = new ArrayList<>();
        while(j < count && !progress.isEmpty()) {
            List<Integer> offer = progress.peek();
            if (offer.get(offer.size()-1)+1 != prev) {
                break;
            }
            offer = progress.poll();
            offer.add(prev);
            add_back.add(offer);
            j++;
        }
        progress.addAll(add_back);
        while (j < count) {
            List<Integer> to_add = new ArrayList<>();
            to_add.add(prev);
            progress.add(to_add);
            j++;
        }
        List<List<Integer>> all_progress = new ArrayList<>();
        all_progress.addAll(progress);
        for (List<Integer> cur_list : all_progress) {
            if (cur_list.size() < 3) {
                return false;
            }
        }
        return true;
    }

}

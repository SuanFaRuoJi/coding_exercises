import java.util.ArrayList;
import java.util.List;

public class jcy_lc725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = root, prev = null;
        int count = 0;
        while (curr != null) {
            count += 1;
            curr = curr.next;
        }
        curr = root;
        prev = curr;
        if (count <= k) {
            int diff = k - count;
            while (curr != null) {
                list.add(curr);
                curr = curr.next;
                prev.next = null;
                prev = curr;
            }
            while (diff != 0) {
                list.add(null);
                diff -= 1;
            }
        } else {
            int groupSize = count / k;
            int groupWithExtra = count % k;
            while (curr != null) {
                int curSize = 0, curGroupSize = groupSize;
                if (groupWithExtra != 0) {
                    curGroupSize += 1;
                    groupWithExtra -= 1;
                }
                list.add(curr);
                while (curSize < curGroupSize) {
                    curSize += 1;
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                curSize = 0;
            }
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
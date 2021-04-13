import java.util.ArrayList;
import java.util.List;

public class jcy_lc1823_1 {
    public int findTheWinner(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        // lastPos stores the index of the starting position in the new list after previous removal
        int step = k, lastPos = 0;
        while (nums.size() != 1) {
            int curSize = nums.size();
            // step stores the actual movement on the list
            if (k >= curSize) step = k % curSize;
            // Edge case 1: when step equals 0, we should remove the last element on the current path
            if (step == 0) {
                // Remove the last element if the starting position is index 0
                if (lastPos - 1 < 0) nums.remove(curSize - 1);
                    // Otherwise remove the element before the starting position due to the nature of loop and decrease lastPos by 1
                else {
                    nums.remove(lastPos - 1);
                    lastPos -= 1;
                }
            } else {
                // If the element we want to remove is the last element, we simple remove it and set lastPos to 0 due to the nature of loop
                if (lastPos + step == curSize) {
                    nums.remove(curSize - 1);
                    lastPos = 0;
                }
                // Two cases:
                // 1. When we bypass the size of the current list, we need to return to the front of the list due to the nature of loop
                // 2. Otherwise we can simply remove the element based on the starting position and the step
                // After removing one element, the starting position for the next loop will be exactly the index of the element we just removed since the size of list was decreased by 1
                else if (lastPos + step > curSize) {
                    nums.remove(lastPos + step - 1 - curSize);
                    lastPos = lastPos + step - 1 - curSize;
                } else {
                    nums.remove(lastPos + step - 1);
                    lastPos = lastPos + step - 1;
                }
            }
        }
        // Eventually we can return the last and only element in the list
        return nums.get(0);
    }
}
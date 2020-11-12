/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
    	boolean[] checked = new boolean[];
		int index = 0, check = 1;
		while (check < n) {
			if (knows(index, check)) { // current person knows check
				checked[index] = true;
				index = check;
			} else {
				checked[check] = true;
			}
			check ++;
		}
		for (int i=0; i<n; i++) {
			if (i != index && knows(index, i)) {
				return -1;
			}
		}
		return index;
    }
}

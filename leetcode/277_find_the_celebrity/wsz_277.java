/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
		int index = 0, check = 1;
		while (check < n) {
			if (knows(index, check)) { // current person knows check
				index = check;
			}
			check ++;
		}
		for (int i=0; i<n; i++) {
			if (i != index && (knows(index, i) || !knows(i, index))) {
				return -1;
			}
		}
		return index;
    }
}

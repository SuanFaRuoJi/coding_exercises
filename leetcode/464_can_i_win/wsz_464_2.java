class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] visited = new boolean[maxChoosableInteger+1];
		Map<Integer, Boolean>[] memory = new Map[desiredTotal+1];
		return search(0, maxChoosableInteger, desiredTotal, 0, memory);
   	}

	private boolean search(int visited, int bound, int total, int round, Map<Integer, Boolean>[] memory) {
		int identifier = visited << 1 + (round%2);
		if (memory[total] != null && memory[total].containsKey(identifier)) {
			return memory[total].get(identifier);
		}

		if (memory[total] == null) {
			momory[total] = new HashMap<>();
		}

		if (total <= 0) { // game ended, whoever gets the run loses.
			boolean result = round == 0 || round % 2 == 1;
			memory[total].put(identifier, result);
			return result;
		}

		int mask = 1;
		for (int i=1; i<=bound; i++) {
			if (visited & mask != 0) {
				continue;
			}
			
			visited |= mask;
			boolean branch = search(visited, bound, total - i, round+1, memory);
            visited &= ~mask;
			if (round % 2 == 0) { // my turn, and I picked i
				if (branch) {
					memory[total].put(identifier, true);
					return true;
				}
			} else { // his turn, and he picked i
				if (!branch) {
					memory[total].put(identifier, false);
					return false;
				}
			}
		}

		boolean result = rount % 2 != 0;
		memory[total].put(identifier, result);
		return result;		
	}	
}

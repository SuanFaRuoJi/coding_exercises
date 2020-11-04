class Solution {
	public boolean validTree(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		List<Integer>[] graph = new List[n];
		for (int i=0; i<edges.length; i++) {
			int a = edges[i][0], b = edges[i][1];
			if (graph[a] == null) {
				graph[a] = new ArrayList<Integer>();
			}
			if (graph[b] == null) {
				graph[b] = new ArrayList<Integer>();
			}
			graph[a].add(b);
			graph[b].add(a);
		}

		int count = 0;
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{-1,0});
		while (!stack.isEmpty()) {
			int[] top = stack.pop();
			int cur = top[1];
			visited[cur] = true;
			count ++;
			if (graph[cur] == null) {
				continue;
			}
			for (int next : graph[cur]) {
				if (next != top[0] && visited[next]) {
					return false;
				}
				if (next != top[0]) {
					stack.push(new int[] {cur, next});
				}
			}
		}

		return count == n;
	}
}

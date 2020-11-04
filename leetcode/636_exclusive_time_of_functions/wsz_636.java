class wsz_636 {
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[];
		Stack<int[]> stack = new Stack<>();
		Stack<Integer> acc = new Stack<>();
		for (String cur : logs) {
			String[] raw = cur.split(":");
			int index = Integer.parseInt(raw[0]);
			boolean start = raw[1].equals("start");
			int time = Integer.parseInt(raw[1]);
			if (start) {
				stack.push(new int[] {index, time});
				acc.push(0);
			} else {
				int[] top = stack.pop();
				int cur_acc = acc.pop();
				result[index] += time - top[1] - cur_acc;
				acc.peek() += time - top[1];
			}
		}
		return result;
    }
}

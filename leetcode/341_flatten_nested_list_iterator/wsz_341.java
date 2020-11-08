public class NestedIterator implements Iterator<Integer> {
	private Iterator<NestedInteger> cur = null;
	private Integer cur_int = null;
	private NestedIterator cur_nest = null;

    public NestedIterator(List<NestedInteger> nestedList) {
		cur = nestedList.iterator();
		next_working();
	}

    @Override
    public Integer next() {
		Integer result = null;
		if (cur_int != null) {
			result = cur_int;
			next_working();
		} else {
			result = cur_nest.next();
			if (!cur_nest.hasNext()) {
				next_working();
			}
		}

		return result;
	}

    @Override
    public boolean hasNext() {
		return cur_int != null || cur_nest != null;
	}

	private void NestedIterator next_working() {
		cur_int = null;
		cur_nest = null;
		while (cur.hasNext()) {
			NestedInteger next = cur.next();
			if (next.isInteger()) {
				cur_int = next.getInteger();
				break;
			}
			NestedIterator potential = new NestedIterator();
			if (potential.hasNext()) {
				cur_nest = potential;
				break;
			}
		}
	}
}

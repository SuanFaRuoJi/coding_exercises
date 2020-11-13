class wsz_155 {
	private List<Integer> store;
	private List<Integer> mono;
	private int size = 0;

    /** initialize your data structure here. */
    public wsz_155() {
        store = new ArrayList<>();
		mono = new ArrayList<>();
    }
    
    public void push(int x) {
        store.add(x);
		mono.add(size == 0 || mono.get(size-1) > x ? x : mono.get(size-1));
		size ++;
    }
    
    public void pop() {
		size --;
        store.remove(size);
		mono.remove(size);
    }
    
    public int top() {
        return store.get(size-1);
    }
    
    public int getMin() {
        return mono.get(size-1);
    }
}

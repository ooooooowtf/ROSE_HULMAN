import java.util.PriorityQueue;

public class PriorityQueueChainManager extends ChainManager {
	private PriorityQueue<Entry> items;
	private String end;

	public PriorityQueueChainManager(String end) {
		this.items = new PriorityQueue<>();
		this.end = end;
	}

	@Override
	public void add(Chain chain) {
		Entry entry = new Entry(chain);
		this.items.add(entry);
		this.updateMax(this.items.size());
	}

	@Override
	public Chain next() {
		if (this.items.isEmpty())
			return null;
		this.incrementNumNexts();
		Entry entry = this.items.poll();
		return entry.getChain();
	}

	@Override
	public boolean isEmpty() {
		return this.items.isEmpty();
	}

//	public int compareCharDiff(String lastWord) {
//		int diffCount = 0;
//		if(lastWord.length() != this.end.length())
//			return 0;
//		for (int i = 0; i < lastWord.length(); i++) {
//			if (this.end.charAt(i) != lastWord.charAt(i))
//				diffCount++;// Makes the comparison: end vs. lastWord
//		}
//		return -1 * diffCount;// Difference is bad.
//	}

	public class Entry implements Comparable<Entry> {
		
		private Chain self;
		private int value;

		public Entry(Chain chain) {
			this.self = chain;
			this.value=0;
			this.setValue();
			
		}
		
		public Chain getChain() {
			return this.self;
		}
		
		public void setValue(){
			this.value =this.self.length();
			for (int i = 0; i < this.self.getLast().length(); i++) {
				if (this.self.getLast().charAt(i) != PriorityQueueChainManager.this.end.charAt(i)) {
					this.value++;
				}
			}
		}
		
		@Override
		public int compareTo(Entry o) {
			return this.value-o.getValue();
		}
		
		public int getValue(){
			return this.value;
		}

		

	}

}

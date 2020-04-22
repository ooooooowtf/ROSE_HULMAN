package graphs;

import java.util.LinkedList;


public class ChainManager {
	LinkedList<Chain> chains;

	public ChainManager() {
		this.chains = new LinkedList<>();
	}

	public void add(Chain chain) {
		this.chains.add(chain);
	}


	public Chain next() {
		return this.chains.removeFirst();
	}

	public boolean isEmpty() {
		return this.chains.isEmpty();
	}
}

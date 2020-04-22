import java.util.Stack;

public class StackChainManager extends ChainManager {
	Stack<Chain> chainStack = new Stack<>();

	@Override
	public void add(Chain chain) {
		this.chainStack.push(chain);
		this.updateMax(this.chainStack.size());
	}

	@Override
	public Chain next() {
		if (this.chainStack.isEmpty())
			return null;
		this.incrementNumNexts();
		return this.chainStack.pop();
	}

	@Override
	public boolean isEmpty() {
		return this.chainStack.isEmpty();
	}

}

package queues;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueFromStacks<T> implements SimpleQueue<T>{
	private Stack<T> top;
	private Stack<T> bottom;
	private int numItems;
	
	
	public static void main(String[] args){
		QueueFromStacks<Integer> q = new QueueFromStacks<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.toString());
	}
	
	
	public QueueFromStacks(){
		this.top = new Stack<T>();
		this.bottom = new Stack<T>();
		this.numItems = 0;
	}

	@Override
	public void clear() {
		this.bottom.clear();
		this.top.clear();
		this.numItems = 0;
		// TODO Auto-generated method stub.
		
	}
	
	@Override
	public String toString(){
		if(this.isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(this.bottom.peek().toString() + ", ");
		
		ArrayList<T> arr = new ArrayList<T>();
		int count = this.numItems -2;
		while(!this.top.isEmpty()){
			arr.add(this.top.pop());
			count--;
		}
		
		for(int i = arr.size() -1; i >=1; i--){
			sb.append(arr.get(i) + ", ");
			this.top.push(arr.get(i));
		}
		
		sb.append(arr.get(0) + "]");
		this.top.push(arr.get(0));
		
		return sb.toString();
	}

	@Override
	public void enqueue(T item) {
		if(this.isEmpty()){
			this.bottom.push(item);
		}else{
			this.top.push(item);
		}
		
		this.numItems++;
		// TODO Auto-generated method stub.
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		
		ArrayList<T> arr = new ArrayList<T>();
		int count = this.numItems -1;
		while(count != 0){
			arr.add(this.top.pop());
			count--;
		}
		T val = this.bottom.pop();
		this.bottom.push(arr.get(arr.size() -1));
		
		arr.remove(arr.size() -1);
		for(int i = arr.size() -1; i >= 0; i--){
			this.top.push(arr.get(i));
		}
		this.numItems--;
		
		return val;
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO Auto-generated method stub.
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		return this.bottom.peek();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub.
		return this.numItems == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub.
		return this.numItems;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub.
		boolean isLast = this.bottom.peek().equals(item);
		if(isLast)
			return true;
		
		return this.top.contains(item);
	}

	@Override
	public String debugString() {
		// TODO Auto-generated method stub.
		return null;
	}

}

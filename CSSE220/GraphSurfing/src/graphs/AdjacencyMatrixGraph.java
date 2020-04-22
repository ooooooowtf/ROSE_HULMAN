package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

public class AdjacencyMatrixGraph<T> extends Graph<T> {
	List<T> indeXs;
	Map<T, Integer> keys;
	int[][] matrix;

	AdjacencyMatrixGraph(Set<T> keys) {
		int size = keys.size();

		this.keys = new HashMap<>();
		this.indeXs = new ArrayList<>();
		this.matrix = new int[size][size];

		int pos = 0;
		for (T key : keys) {
			this.indeXs.add(key);
			this.keys.put(key, pos);
			pos++;
		}
	}

	@Override
	public int size() {
		return this.keys.size();
	}

	@Override
	public int numEdges() {
		int count = 0;
		for (int i = 0; i < this.size(); i++) {
			for (int k = 0; k < this.size(); k++) {
				count += this.matrix[i][k];
			}
		}
		return count;
	}

	@Override
	public boolean addEdge(T from, T to) {
		if (!this.hasVertex(from) || !this.hasVertex(to)) {
			throw new NoSuchElementException();
		}
		int vertical = this.keys.get(from);
		int hori = this.keys.get(to);
		if (this.matrix[vertical][hori] == 1) {
			return false;
		}
		this.matrix[vertical][hori] = 1;
		return true;
	}

	@Override
	public boolean hasVertex(T key) {
		return this.keys.containsKey(key);
	}

	@Override
	public boolean hasEdge(T from, T to) throws NoSuchElementException {
		if (!this.hasVertex(from) || !this.hasVertex(to)) {
			throw new NoSuchElementException();
		}
		int vertical = this.keys.get(from);
		int horizonal = this.keys.get(to);
		return this.matrix[vertical][horizonal] == 1;
	}

	@Override
	public boolean removeEdge(T from, T to) throws NoSuchElementException {
		if (!this.hasVertex(from) || !this.hasVertex(to)) {
			throw new NoSuchElementException();
		}
		int vertical = this.keys.get(from);
		int horizonal = this.keys.get(to);
		if (this.matrix[vertical][horizonal] == 0) {
			return false;
		}
		this.matrix[vertical][horizonal] = 0;
		return true;
	}

	@Override
	public int outDegree(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		int count = 0;
		int index = this.keys.get(key);
		for (int i = 0; i < this.size(); i++) {
			if (this.matrix[index][i] == 1) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int inDegree(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		int count = 0;
		int index = this.keys.get(key);
		for (int i = 0; i < this.size(); i++) {
			if (this.matrix[i][index] == 1) {
				count++;
			}
		}
		return count;
	}

	@Override
	public Set<T> keySet() {
		return this.keys.keySet();
	}

	@Override
	public Set<T> successorSet(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}

		Set<T> tems = new HashSet<>();
		int index = this.keys.get(key);

		for (int i = 0; i < this.size(); i++) {
			if (this.matrix[index][i] == 1) {
				tems.add(this.indeXs.get(i));
			}
		}
		return tems;
	}

	@Override
	public Set<T> predecessorSet(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Set<T> s = new HashSet<>();
		int index = this.keys.get(key);
		for (int i = 0; i < this.size(); i++) {
			if (this.matrix[i][index] == 1) {
				s.add(this.indeXs.get(i));
			}
		}
		return s;
	}

	@Override
	public Iterator<T> successorIterator(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		return new SuccessorIterator(this.keys.get(key));
	}

	public class SuccessorIterator implements Iterator<T> {
		int current;
		int index;
		int max;

		public SuccessorIterator(Integer integer) {
			this.current = 0;
			this.max = size();
			this.index = integer;

		}

		@Override
		public boolean hasNext() {
			while (this.current < this.max) {
				if (AdjacencyMatrixGraph.this.matrix[this.index][this.current] == 1) {
					break;
				}
				this.current++;
			}
			return this.current < this.max;
		}

		@Override
		public T next() {
			while (AdjacencyMatrixGraph.this.matrix[this.index][this.current] != 1) {
				this.current++;
			}
			this.current++;
			return AdjacencyMatrixGraph.this.indeXs.get(this.current - 1);
		}
	}

	@Override
	public Iterator<T> predecessorIterator(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		return new PredecessorIterator(this.keys.get(key));
	}

	public class PredecessorIterator implements Iterator<T> {
		int current;
		int index;
		int max;

		public PredecessorIterator(Integer integer) {
			this.current = 0;
			this.max = size();
			this.index = integer;

		}

		@Override
		public boolean hasNext() {
			while (this.current < this.max) {
				if (AdjacencyMatrixGraph.this.matrix[this.current][this.index] == 1) {
					break;
				}
				this.current++;
			}
			return this.current < this.max;
		}

		@Override
		public T next() {
			while (AdjacencyMatrixGraph.this.matrix[this.current][this.index] != 1) {
				this.current++;
			}
			this.current++;
			return AdjacencyMatrixGraph.this.indeXs.get(this.current - 1);
		}
	}

	@Override
	public Set<T> stronglyConnectedComponent(T key) {
		if(!hasVertex(key)){
			throw new NoSuchElementException();
		}
		
		Set<T> toReturn = new HashSet<>();
		toReturn.add(key);
		Set<T> allSuccesors = new HashSet<>();
		Set<T> allPredecessors = new HashSet<>();
		Stack<T> s1 = new Stack<>();
		s1.push(key);
		while(!s1.isEmpty()){
			T current = s1.pop();
			for(T k:this.successorSet(current)){
				if(allSuccesors.add(k)){
					s1.push(k);
				}
			}
		}
		s1.push(key);
		while(!s1.isEmpty()){
			T current = s1.pop();
			for(T k:this.predecessorSet(current)){
				if(allPredecessors.add(k)){
					s1.push(k);
				}
			}
		}
		for(T k:allPredecessors){
			if(allSuccesors.contains(k)){
				toReturn.add(k);
			}
		}
		return toReturn;
	}

	@Override
	public List<T> shortestPath(T startLabel, T endLabel) {
		if((!hasVertex(startLabel))||(!hasVertex(endLabel))){
			throw new NoSuchElementException();
		}
		Chain<T> chain = new Chain<>();
		chain = chain.addLast(startLabel);
		ChainManager manager = new ChainManager();
		manager.add(chain);
		HashSet<T> verticeVisited= new HashSet<>();

		while (!manager.isEmpty()) {
			chain = manager.next();
			if (chain.getLast().equals(endLabel)) return chain.toList();
			Set<T> set = this.successorSet(chain.getLast());
			if (set != null) {
				for (T s : set) {
					if(s.equals(endLabel)) return chain.addLast(s).toList();
					if(!verticeVisited.contains(s)) manager.add(chain.addLast(s));
					verticeVisited.add(s);
				}
			}
		}
		return null;
	}
}

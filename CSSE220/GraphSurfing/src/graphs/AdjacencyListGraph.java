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

public class AdjacencyListGraph<T> extends Graph<T> {
	Map<T, Vertex> keyToVertex;

	private class Vertex {
		T key;
		List<Vertex> successors;
		List<Vertex> predecessors;

		Vertex(T key) {
			this.key = key;
			this.successors = new ArrayList<>();
			this.predecessors = new ArrayList<>();
		}
	}

	AdjacencyListGraph(Set<T> keys) {
		this.keyToVertex = new HashMap<>();

		for (T key : keys) {
			Vertex v = new Vertex(key);
			this.keyToVertex.put(key, v);
		}
	}

	@Override
	public int size() {
		return this.keyToVertex.size();
	}

	@Override
	public int numEdges() {
		int num = 0;
		for (T ver : this.keyToVertex.keySet()) {
			num = num + this.keyToVertex.get(ver).successors.size();
		}
		return num;
	}

	@Override
	public boolean addEdge(T from, T to) {
		if (!this.hasVertex(from) || !this.hasVertex(to)) {
			throw new NoSuchElementException();
		}

		Vertex start = this.keyToVertex.get(from);
		Vertex end = this.keyToVertex.get(to);
		if (start.successors.contains(end) || end.predecessors.contains(start)) {
			return false;
		}
		start.successors.add(end);
		end.predecessors.add(start);
		return true;
	}

	@Override
	public boolean hasVertex(T key) {
		return this.keyToVertex.keySet().contains(key);
	}

	@Override
	public boolean hasEdge(T from, T to) throws NoSuchElementException {
		if (!this.hasVertex(from) || !this.hasVertex(to)) {
			throw new NoSuchElementException();
		}
		Vertex start = this.keyToVertex.get(from);
		Vertex end = this.keyToVertex.get(to);
		if (start.successors.contains(end)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdge(T from, T to) throws NoSuchElementException {
		if (!hasEdge(from, to)) {
			return false;
		}
		Vertex vFrom = this.keyToVertex.get(from);
		Vertex vTo = this.keyToVertex.get(to);
		vFrom.successors.remove(vTo);
		vTo.predecessors.remove(vFrom);
		return true;
	}

	@Override
	public int outDegree(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Vertex v = this.keyToVertex.get(key);
		return v.successors.size();
	}

	@Override
	public int inDegree(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Vertex v = this.keyToVertex.get(key);
		return v.predecessors.size();
	}

	@Override
	public Set<T> keySet() {
		return this.keyToVertex.keySet();
	}

	@Override
	public Set<T> successorSet(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Vertex v = this.keyToVertex.get(key);
		Set<T> s = new HashSet<>();
		for (Vertex ver : v.successors) {
			s.add(ver.key);
		}
		return s;
	}

	@Override
	public Set<T> predecessorSet(T key) {
		if(!hasVertex(key)){
			throw new NoSuchElementException();
		}
		Vertex vt = this.keyToVertex.get(key);
		Set<T> toReturn = new HashSet<>();
		for(Vertex v : vt.predecessors){
			toReturn.add(v.key);
		}
		return toReturn;
	}

	@Override
	public Iterator<T> successorIterator(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Vertex ver = this.keyToVertex.get(key);
		return new SuccessorIterator(ver.successors.iterator());
	}

	public class SuccessorIterator implements Iterator<T> {
		Iterator<Vertex> ite;

		public SuccessorIterator(Iterator<AdjacencyListGraph<T>.Vertex> iterator) {
			this.ite = iterator;
		}

		@Override
		public boolean hasNext() {
			return this.ite.hasNext();
		}

		@Override
		public T next() {
			return this.ite.next().key;
		}

	}

	@Override
	public Iterator<T> predecessorIterator(T key) {
		if (!this.hasVertex(key)) {
			throw new NoSuchElementException();
		}
		Vertex ver = this.keyToVertex.get(key);
		return new PredecessorIterator(ver.predecessors.iterator());
	}

	public class PredecessorIterator implements Iterator<T> {
		Iterator<Vertex> ite;

		public PredecessorIterator(Iterator<AdjacencyListGraph<T>.Vertex> iterator) {
			this.ite = iterator;
		}

		@Override
		public boolean hasNext() {
			return this.ite.hasNext();
		}

		@Override
		public T next() {
			return this.ite.next().key;
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

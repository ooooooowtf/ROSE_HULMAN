package quack;

import java.util.NoSuchElementException;

/**
 * A class to implement the Quack ADT.
 *
 * @author Nate Chenette and << Your Name Here >>. Created Dec 15, 2016.
 */

public class Quack {
	SinglyLinkedList list; // Data must be stored here.
	boolean inStackMode; // true if Quack in stack mode, false if in queue mode.

	public Quack() {
		this.list = new SinglyLinkedList();
		this.inStackMode = true; // Quack always starts in stack mode
	}

	public void toStackMode() {
		if (inStackMode) {
			return;
		}
		inStackMode = true;
		reverseList();
	}

	public void toQueueMode() {
		if (!inStackMode) {
			return;
		}
		inStackMode = false;
		reverseList();
	}

	private void reverseList() {
		Node oldNode = list.head;
		list.head = null;
		while (oldNode != null) {
			list.head = new Node(oldNode.data, list.head);
			oldNode = oldNode.next;
		}
	}

	public void insert(String newitem) {
		if (inStackMode || this.isEmpty()) {
			list.head = new Node(newitem, list.head); // top of stack is head of
														// list
		} else {
			lastNode().next = new Node(newitem, null); // back of queue is end
														// of list
		}
	}

	private Node lastNode() {
		if (this.isEmpty()) {
			return null;
		}
		Node nd = list.head;
		while (nd.next != null) {
			nd = nd.next;
		}
		return nd;
	}

	public boolean isEmpty() {
		return (list.head == null);
	}

	public String retrieve() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		String result = list.head.data;
		list.head = list.head.next;
		return result;
	}
	// ------- Code below this point should not be changed -------

	// For testing purposes
	public String toString() {
		return this.list.toString();
	}

	/**
	 * Basic singly linked list.
	 */
	public class SinglyLinkedList {
		Node head;

		SinglyLinkedList() {
			this.head = null;
		}

		// For testing/debugging purposes
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("[");
			Node nd = this.head;
			if (nd != null) {
				s.append(nd.data);
				nd = nd.next;
			}
			while (nd != null) {
				s.append(", ");
				s.append(nd.data);
				nd = nd.next;
			}
			s.append("]");
			return s.toString();
		}
	}

	/**
	 * Basic node.
	 */
	class Node {
		String data;
		Node next;

		Node(String item, Node nextNode) {
			this.data = item;
			this.next = nextNode;
		}
	}

}

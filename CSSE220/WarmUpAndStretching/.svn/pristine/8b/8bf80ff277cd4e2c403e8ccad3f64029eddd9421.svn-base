package list;

/**
 * 
 * @author anderson
 * 
 * @param <T>
 *            Any Comparable type
 * 
 *            A linked list whose elements are kept in sorted order.
 */
public class SortedLinkedList<T extends Comparable<T>> extends
		DoublyLinkedList<T> {

	/**
	 * Create an empty list
	 * 
	 */
	public SortedLinkedList() {
		super();
	}

	/**
	 * Creates a sorted list containing the same elements as the parameter
	 * 
	 * @param list
	 *            the input list
	 */
	public SortedLinkedList(DoublyLinkedList<T> list) {
		super();
		DLLIterator<T> i = list.iterator();
		while (i.hasNext()) {
			this.add(i.next());
		}
	}

	/**
	 * Adds the given element to the list, keeping it sorted.
	 */
	@Override
	public void add(T element) {
		// TODO: implement this method
		super.addFirst(element);
		Node current = this.head.next.next;
		while(current.next!=null){
			if(current.data.compareTo(element)<0){
				T data = current.data;
				current.data=current.prev.data;
				current.prev.data=data;
			}
			current = current.next;
		}
	}

	@Override
	public void addFirst(T element) {
		// TODO: throw UnsupportedOperationException exception
		if(this.isEmpty()){
			throw new UnsupportedOperationException("fail");
		}
		super.addFirst(element);
	}

	@Override
	public void addLast(T element) {
		
		// TODO: throw UnsupportedOperationException exception
		if(this.isEmpty()){
			throw new UnsupportedOperationException("fail");
		}
		super.addLast(element);
		
	}
}

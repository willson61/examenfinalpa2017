package gt.edu.url.problema3;


public class ImplLeakyStack<E> implements LeakyStack<E>{
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		
	}
	private Node<E> tail = null;
	private int size = 0;
	private int maxValue;
	public ImplLeakyStack(int maxValue) {
		super();
		this.maxValue = maxValue;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public E saveHistory(E e) {
		if(size == maxValue) {
			tail = tail.next;
			Node<E> newest = new Node<>(e, tail);
			tail.setNext(newest);
		}
		else {
			if(size == 0) {
				tail = new Node<>(e, null);
				tail.setNext(tail);
			}
			else {
				Node<E> newest = new Node<>(e, tail.getNext());
				tail.setNext(newest);
			}
			size++;
		}
		return e;
	}

	@Override
	public E actual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E undo() {
		if(isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();
		if(head == tail) {
			tail = null;
		}
		else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}

}

package gt.edu.url.problema2;

public interface List<E> {
	int size();
	boolean isEmpty();
	E get(int i);
	E set(int i, E e);
	void add(int i, E e);
	E remove(int i) throws IndexOutOfBoundsException;
	String toString();
}

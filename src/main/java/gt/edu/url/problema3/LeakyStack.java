package gt.edu.url.problema3;

/**
 * Historic stack ADT representation
 */

public interface LeakyStack<E> {

	/**
	 * Returns stack elements count
	 * @return number of elements in stack
	 */
	int size();
	
	/**
	 * Checks if stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Inserts an element in the stack and raises a leak opperation as needed
	 * @param e element to be inserted
	 */
	E saveHistory(E e);
	
	/**
	 * Retrieves the last element of the stack without remotion
	 * @return Last stack element (null if empty)
	 */
	E actual();
	
	/**
	 * Retrieves the last element of the stack removing it
	 * @return Last stack element (null if empty)
	 */
	E undo();
}

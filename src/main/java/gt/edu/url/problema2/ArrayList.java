package gt.edu.url.problema2;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
	/**
	 * 
	 * @Will
	 */
	public static final int CAPACITY = 16;
	private E[ ] data;
	private int size = 0;
	public ArrayList() {
		this(CAPACITY);
	} 
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}
	/**
	 * devuelve el tama�o de la lista
	 */
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E get(int i) {
		checkIndex(i, size);
		return data[i];
	}
	public E set(int i, E e) {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	public void add(int i, E e) {
		checkIndex(i, size);
		if(size == data.length) {
			throw new IllegalStateException("Array is full");
		}
		for(int k = size - 1; k >= i; k--) {
			data[k+1]=data[k];
		}
		data[i] = e;
		size++;
	}
	//Add con resize
	/*public void add(int i, E e) {
		checkIndex(i, size);
		if(size == data.length) {
			resize(2 * data.lenght);
		}
		for(int k = size - 1; k >= i; k--) {
			data[k+1]=data[k];
		}
		data[i] = e;
		size++;
	}*/
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for(int k = i; k < size - 1;k++) {
			data[k]=data[k+1];
		}
		data[size-1]=null;
		size--;
		return temp;
	}
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
	}
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for(int k = 0; k < size; k++) {
			temp[k] = data[k];
		}
		data = temp;
	}
	public String toString() {
		String elementos="";
		for(int i = 0; i<size;i++) {
			if(data[i]!=null) {
				elementos += ", "+data[i];
			}
		}
		return elementos;
	}
	public int permut(E[] l) {
		E e;
		int cont;
		if(size() == 1) {
			for(int i = 0; i < data.length; i++) {
				System.out.println(data[i]);
				cont++;
			}
		}
		else {
			for(int i = 0; i < (size() - 1); i++) {
				permut(data);
				if(size() % 2 == 0) {
					e = data[i];
					data[i] = data[size() - 1];
					data[size() - 1] = e;
					cont++;
				}
				else {
					e = data[0];
					data[0] = data[size()-1];
					data[size()-1] = e;
					cont++;
				}
			}
			permut(data);
		}
	}
}

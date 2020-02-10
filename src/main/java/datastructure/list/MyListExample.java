package datastructure.list;

import java.util.Arrays;

public class MyListExample<E> {
	private int SIZE=10;
	Object[] objects = new Object[SIZE];
	private int counter=0;
	
	
	public MyListExample() {
		
	}
	
	public void add(E element) {
		if(counter== objects.length) {
			doubledArray();
		}
		objects[counter++] = element;
	}
	
	public E get(int index) {
		if(index>counter-1) {
			throw new RuntimeException("Index Out of Bound Exception");
		}
		return (E) objects[index];
	}
	
	private void doubledArray() {
		SIZE=SIZE*2;
		objects = Arrays.copyOf(objects, SIZE);
	}
	
	public static void main(String args[]) {
		MyListExample<Integer> myList = new MyListExample<>();
		myList.add(2);
		myList.add(6);
		myList.add(10);
		
		System.out.println(myList.get(1));
		
		System.out.println(myList.get(7));
	}

}

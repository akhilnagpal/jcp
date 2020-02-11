package datastructure.stack;

import java.util.Arrays;

public class StackImplementation<E> {
	
	Object [] elements;
	int counter=0;
	
	public StackImplementation() {
		elements = new Object[10];
	}
	
	public void push(E element) {
		if(elements.length>counter) {
			elements[counter++]=element;
		} else {
			resize();
		}
	}
	
	private void resize () {
		int newSize=elements.length*2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		E element =  (E) elements[--counter];
		// If you do not do below step, stack will still hold this element unitl another push comes. 
		// Classis case of memory leak
		elements[counter]=null;
		return element;
	}
	
	public static void main(String args[]) {
		StackImplementation<Integer> stackImplementation = new StackImplementation<Integer>();
		stackImplementation.push(1);
		stackImplementation.push(2);
		stackImplementation.push(3);
		stackImplementation.push(4);
		stackImplementation.push(5);
		stackImplementation.push(6);
		System.out.println(stackImplementation.pop());
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		stackImplementation.push(1);
		System.out.println(stackImplementation.pop());
		
	}

}

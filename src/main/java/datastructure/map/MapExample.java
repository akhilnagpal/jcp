package datastructure.map;

import java.util.Arrays;

public class MapExample<K,V> {
	
	int DEFAULT_CAPACITY = 10;
	MyEntry<K,V>[] myEntryArray = new MyEntry[DEFAULT_CAPACITY];
	public int size=0;

	public static void main(String[] args) {
		
		MapExample<String, Integer> map = new MapExample<String, Integer>();
        map.put("Lars", 1);
        map.put("Lars", 2);
        map.put("Lars", 1);
        System.out.println(map.get("Lars"));
        
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }
        System.out.println(map.size);
        System.out.println(map.get("51"));
	}
	
	void put(K key,V value) {
		
		boolean newKey = true;
		for(int i=0;i<myEntryArray.length;i++) {
			if(myEntryArray[i]!=null && myEntryArray[i].getKey().equals(key)) {
				myEntryArray[i].setValue(value);
				newKey=false;
			}
		}
		if(newKey) {
			if(size==myEntryArray.length) {
				copyMap();
			}
			myEntryArray[size++] = new MyEntry(key, value);
		}
		
	}
	
	V get(K key) {
		
		for(int i=0;i<myEntryArray.length;i++) {
			if(myEntryArray[i]!=null && myEntryArray[i].getKey().equals(key)) {
				return myEntryArray[i].getValue();
			}
		}
		return null;
	}
	
	boolean remove(K key) {
		boolean removeit=false;
		for(int i=0;i<myEntryArray.length;i++) {
			if(myEntryArray[i]!=null && myEntryArray[i].getKey().equals(key)) {
				myEntryArray[i]=null;
				removeit=true;
				size--;
				condenseArray(i);
			}
		}
		
			
		
		return removeit;
	}
	
	//Rearranging the array after delete
	void condenseArray(int start) {
		for(int i=start;i<myEntryArray.length;i++) {
			myEntryArray[i]=myEntryArray[i+1];
		}
	}
	
	void copyMap( ) {
		
		myEntryArray = Arrays.copyOf(myEntryArray, myEntryArray.length*2);
	}

}


class MyEntry<K,V> {
	
	K key;
	V value;	
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public MyEntry(K key, V value) {
		this.key=key;
		this.value=value;
	}
	
}

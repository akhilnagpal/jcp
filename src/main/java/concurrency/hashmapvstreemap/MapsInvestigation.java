package concurrency.hashmapvstreemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsInvestigation {
	
	public static HashMap<String, String> hashMap = new HashMap<String, String>();
	public static TreeMap<String, String> treeMap = new TreeMap<String, String>();
	public static ArrayList<String> list = new ArrayList<String>();

	static {
	    for (int i = 0; i < 10000; i++) {
//	    	Integer.toString(i, 16) - returns number in 16 radix (hex)
//	    	System.out.println(Integer.toString(i, 16));
	        list.add(Integer.toString(i, 16));
	    }
	}


	public static void main(String[] args) {
	    System.out.println("Warmup populate");
	    for (int i = 0; i < 1000; i++) {
	        populateSet(hashMap);
	        populateSet(treeMap);
	    }
	    measureTimeToPopulate(hashMap, "HashMap", 1000);
	    measureTimeToPopulate(treeMap, "TreeMap", 1000);

	    System.out.println("Warmup get");
	    for (int i = 0; i < 1000; i++) {
	        get(hashMap);
	        get(treeMap);
	    }
	    measureTimeToContains(hashMap, "HashMap", 1000);
	    measureTimeToContains(treeMap, "TreeMap", 1000);

	}

	private static void get(Map<String, String> map) {
	    for (String s : list) {
	        map.get(s);
	    }

	}

	private static void populateSet(Map<String, String> map) {
	    map.clear();
	    for (String s : list) {
	        map.put(s, s);
	    }

	}


	private static void measureTimeToPopulate(Map<String, String> map, String setName, int reps) {
	    long start = System.currentTimeMillis();
	    for (int i = 0; i < reps; i++) {
	        populateSet(map);
	    }
	    long finish = System.currentTimeMillis();
	    System.out.println("Time to populate " + (reps * map.size()) + " entries in a " + setName + ": " + (finish - start));
	}

	private static void measureTimeToContains(Map<String, String> map, String setName, int reps) {
	    long start = System.currentTimeMillis();
	    for (int i = 0; i < reps; i++) {
	        get(map);
	    }
	    long finish = System.currentTimeMillis();
	    System.out.println("Time to get() " + (reps * map.size()) + " entries in a " + setName + ": " + (finish - start));
	}

}

package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> list1 = new ArrayList<>();
    	for(int i=1000; i<2000; i++) {
    		list1.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> list2 = new LinkedList<>();
    	list2.addAll(list1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int tmp = list1.get(list1.size() - 1);
    	list1.set(list1.size() - 1, list1.get(list1.size() - list1.size()));
    	list1.set((list1.size() - list1.size()), tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(Integer l : list1) {
    		System.out.println(l);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	for(int i=0; i<=100000; i++) {
    		list1.set(0, i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Converting " + 100_000
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / 1_000_000 + "ms)");
        
    	time = System.nanoTime();
    	for(int i=0; i<=100000; i++) {
    		list2.set(0, i);
    	}
    	time = System.nanoTime() - time;
        System.out.println("Converting " + 100_000
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / 1_000_000 + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for(int i=0; i<=1000; i++) {
    		list1.get(list1.size() / 2);
    	}
        time = System.nanoTime() - time;
        System.out.println("Converting " + 100_000
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / 1_000_000 + "ms)");
        
        time = System.nanoTime();
        for(int i=0; i<=1000; i++) {
    		list2.get(list2.size() / 2);
    	}
        time = System.nanoTime() - time;
        System.out.println("Converting " + 100_000
                + " int to String and inserting them in a Set took " + time
                + "ns (" + time / 1_000_000 + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742452000L);
        map.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        Long res = 0L;
        for (Long d : map.values()) {
        	res += d;
        }
        System.out.println(res);
    }
}

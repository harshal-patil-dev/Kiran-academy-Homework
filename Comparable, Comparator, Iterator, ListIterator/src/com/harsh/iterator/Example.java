package com.harsh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example {

	public static void main(String args[]) {

		List<String> names = new ArrayList<String>();
		
		names.add("Harsh");
		names.add("Yash");
		names.add("Mahesh");
		names.add("Darshan");
		names.add("Rohit");
		
		/* for(String name: names) { // ConcurrentModificationException
			if(name.equals("Harsh")) {
				System.out.println("Mahesh found");
				names.remove(name);
			}
		} */
		
		 Iterator<String> iterator_names = names.iterator();
		
		while(iterator_names.hasNext()) {
			if(iterator_names.next().equals("Mahesh")) {
				iterator_names.remove(); // only remove method
			}
		
		}
		
		System.out.println(names);

	}

}

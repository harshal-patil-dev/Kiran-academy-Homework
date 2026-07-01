package com.harsh.ListIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Example {
	
	public static void main(String args[]) {
		
		List<String> names = new ArrayList<>();
		
		names.add("Harsh");
		names.add("Yash");
		names.add("Mahesh");
		names.add("Darshan");
		names.add("Rohit");
		
        ListIterator<String> ListIterator_names = names.listIterator();
        
       while(ListIterator_names.hasNext()) {
        	if(ListIterator_names.next().equals("Harsh")) {
        		ListIterator_names.set("Harshal"); // remove, update, add possible
        		ListIterator_names.add("Sunil");
        		
        	}
        	
        }
		
		System.out.println(names);
		
		System.out.println();
		
		System.out.println("Using previous:");
		while(ListIterator_names.hasPrevious()) {
			 String name = ListIterator_names.previous();
	        	System.out.println(name);
			 
		 }    	

	}
	
}

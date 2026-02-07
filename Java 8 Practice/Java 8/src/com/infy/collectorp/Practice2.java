package com.infy.collectorp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {

	
	public static void main(String[] args) {
		List<String> names = List.of("Rajan","Chintan","Deepak","Sameer","Sagar", "Maqbool");
		
		//Group names by their first character and count how many names fall under each character.
		names.stream().collect(Collectors.groupingBy(
				
				s->s.charAt(0),
				
				Collectors.counting()
				
				
				)).forEach((k,v)-> System.out.println(k + " "  + v));
		
		
		//Group by first character and store uppercase versions of each name.
		
		names.stream().collect(
				 
				Collectors.groupingBy(
						
						s->s.charAt(0),
						
						Collectors.mapping(String::toUpperCase,Collectors.toList())
						
						
						
						)
				
				
				).forEach((k,v)-> System.out.println(k + " "  + v));
		
		//Group by first character and compute the total length of names under each group.
		names.stream().collect(
				Collectors.groupingBy(
						s->s.charAt(0),
						Collectors.summingInt(String :: length)    				
						)
				
				).forEach((k,v)-> System.out.println(k + " "  + v));
		
		
		//Group by first character and find the longest name in each group.
		names.stream().collect(
				Collectors.groupingBy(
						s->s.charAt(0),
						Collectors.maxBy(Comparator.comparingInt(String :: length))				
						)
				
				).forEach((k,v)-> System.out.println(k + " "  + v));
		
		
	}
}

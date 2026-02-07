package com.infy.collectorp;

import java.util.List;
import java.util.stream.Collectors;

public class Questions {
	


	public static void main(String[] args) {
		
//		Question 1 (Warm-up)
		//
//			Given a List<String> names
//			👉 Group names by their first character.
		//
//			Expected type:
		//
//			Map<Character, List<String>>
		List<String> list = List.of("Aman","Mahesh","Rajan","Anit","Mukesh");
		
		list.stream().collect(
				Collectors.groupingBy(
						
						s->s.charAt(0)
						
						)
				
				).forEach((k,v)->System.out.println(k + " " + v));
		
//		
//		Using the same List<String> names
//		👉 Count how many names start with each character.
//
//		Expected type:
//
//		Map<Character, Long>
	
            list.stream().collect(
            		
            		Collectors.groupingBy(
            				s->s.charAt(0),
            				Collectors.counting()
            				
            				)
            		
            		).forEach((k,v)->System.out.println(k + " "  + v));
            
            
//        	Question 3 (Downstream – Mapping)
            //
//            	From List<String> names
//            	👉 Group by first character and store only the lengths of names.
            //
//            	Expected type:
            //
//            	Map<Character, List<Integer>>
            
            
            
            list.stream().collect(
            		
            		Collectors.groupingBy(
            				
            				s->s.charAt(0),
            				Collectors.summingInt(String :: length)
            				
            				)
            		
            		
            		
            		).forEach((k,v)-> System.out.println(k + " " + v));
            
            
            
            
		}
	

	
	
	
	
}

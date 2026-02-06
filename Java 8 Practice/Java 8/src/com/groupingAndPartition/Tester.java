package com.groupingAndPartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tester {
	
	
	public static Map<Character, List<String>> returnGroup(List<String> list){
		
		Map<Character, List<String>> map=new HashMap<>();
		for (String string : list) {
			char c=string.charAt(0);
			if(!map.containsKey(c)) {
				
				map.put(c, new ArrayList<>());
				
			}
			map.get(c).add(string);
		}
		return map;
		
	}
	
	public static Map<Character, List<String>> returnGroupUsingGroupingBy(List<String> list){
		
		return list.stream().collect(Collectors
				
				.groupingBy(s->s.charAt(0))
				
				);
		
	}
	
	public static void main(String[] args) {
		
		List<String> list=List.of("Ram" , "Shyam", "Nameesh", "Rahul");
		System.out.println(returnGroup(list));
		System.out.println(returnGroupUsingGroupingBy(list));
		
	}

}

package com.infy.collectorp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByPractice {
	
	
	public static void main(String[] args) {
		List<Integer> list=List.of(12,14,15,64);
		
        Map<String, List<Integer>> map=list.stream().collect(Collectors.groupingBy(
        		
        		
        		n->n%2==0?"Even":"Odd"));
        
        map.forEach(
        		
        		(k,v)->System.out.println(k + " " + v)
        		
        		);
	}
}

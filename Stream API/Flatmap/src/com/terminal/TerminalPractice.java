package com.terminal;

import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TerminalPractice {
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 6, 2, 8, 5, 9, 1);
		
		//Count how many numbers are greater than 5
		
        long countNumbers =		numbers.stream().filter(n->n>5).count();
        System.out.println(countNumbers);
        
        
        //Convert the stream into an array and print it
         Object  [] listArray=numbers.stream().toArray();
         System.out.println(Arrays.toString(listArray));
         
         
         //Collect all even numbers into a List
         List<Integer> list=numbers.stream().filter(n->n%2==0) .collect(Collectors.toList());
         System.out.println(list);
         list.forEach(l->System.out.println(l));
         
         //Find the sum of all numbers using reduce
         
         int sum=numbers.stream().reduce(0, (a,b)->a+b);
         System.out.println(sum);
         
         
	}

}

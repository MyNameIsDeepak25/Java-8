package com.infy.collectorp;

import java.util.List;
import java.util.stream.Collectors;

public class Practice {
	
	
	public static void main(String[] args) {
		List<String> words = List.of("Java", "is", "fun");
		
	String s=	words.stream().collect(Collectors.joining(" "));
    Long count=words.stream().collect(Collectors.counting());
	
	System.out.println(s);
	System.out.println(count);
	
	 Integer sum1=words.stream().collect(Collectors.summingInt(String::length));
	 Integer sum2=words.stream().collect(Collectors.summingInt(s1->s1.length()));
	 System.out.println(sum2);

	}

}

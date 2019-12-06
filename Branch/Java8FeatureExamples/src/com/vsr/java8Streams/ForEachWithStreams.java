package com.vsr.java8Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachWithStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l_lstobj=Arrays.asList("santhosh","Mani","Raghav","Reddy","Mani");
		System.out.println("findFirst===>"+l_lstobj.stream().findFirst());
		System.out.println("Distinct===>"+l_lstobj.stream().distinct().collect(Collectors.toList()));
		System.out.println("Predicate===>"+l_lstobj.stream().filter(s->s.length()<=5).collect(Collectors.toSet()));
		System.out.println("findAny===>"+l_lstobj.stream().findAny());
		System.out.println("isParallel===>"+l_lstobj.stream().isParallel());
	}

}

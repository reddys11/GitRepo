package com.vsr.java8Streams;

import java.util.Arrays;
import java.util.List;

public class ForEachWithoutStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l_lstobj=Arrays.asList("santhosh","Mani","Raghav","Reddy","Mani");
		l_lstobj.forEach(s->System.out.println(s));
	}

}

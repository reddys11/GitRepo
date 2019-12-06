package com.vsr.MethodReference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l_lstobj=Arrays.asList("santhosh","Mani","Raghav","Reddy","Mani");
		l_lstobj.forEach(System.out::println);
	}

}

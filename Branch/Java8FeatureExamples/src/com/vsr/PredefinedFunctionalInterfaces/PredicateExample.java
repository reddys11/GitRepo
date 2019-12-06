package com.vsr.PredefinedFunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
public static void main(String[] args) {
	String s1="Santhosh";
	Predicate<String> p1=s->s.length()>3;
	System.out.println("p1 Result::"+p1.test(s1));
	
	Predicate<String> p2=s->s.isEmpty();
	System.out.println("P2 Result::"+p2.test(""));
	//Combining two predicates
	System.out.println("Joined predicates using or::"+p1.or(p2).test("Santhosh"));
	System.out.println("Joined predicates using and::"+p1.and(p2).test("Santhosh"));
}
}

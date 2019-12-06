package com.vsr.PredefinedFunctionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
	    Function<Integer,Integer> f1=i->i*i;
	    System.out.println("f1 Result::"+f1.apply(10));
	    Function<Integer,Boolean> f2=i->i>=100;
	    System.out.println("F2 Result::"+f2.apply(20));
	    //joining two functions
	    System.out.println("Joining f1 and f2::"+f1.andThen(f2).apply(10));
	    //In the above line f1 is executed and the result(100) is provided to f2,then f2 is executed.
	    Function<String,Integer> f3=s->s.length();
	    System.out.println("Joining f1 and f3 using compose::"+f1.compose(f3).apply("santhosh"));
	    //In the above line f3 is executed first and the result(8) is given to f1.
		}

}

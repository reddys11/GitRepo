package com.vsr.PredefinedFunctionalInterfaces;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		// Without Input provide output by doing some operation.
		Supplier<String> s1=()->"hello";
		Supplier<Double> s2=()->{return Math.random();};
        System.out.println(s1.get());
        System.out.println(s2.get());
	}

}
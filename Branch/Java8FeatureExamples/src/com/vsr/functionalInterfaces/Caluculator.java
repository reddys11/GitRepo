package com.vsr.functionalInterfaces;

//@FunctionalInterface
public interface Caluculator {
		public int add(int a,int b);
		public static void sub(int a,int b) {
			System.out.println(a-b);
		}
		public default void  mul(int a,int b) {
			System.out.println(a*b);
		}
}

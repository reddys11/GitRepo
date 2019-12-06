package com.vsr.DefaultAndStaticMethods;

interface Printmessage{
	default void print() {
		System.out.println("Hello Santhosh");
	}
}
interface PrintText{
	default void print() {
		System.out.println("Hello Reddy");
	}
}
/*If we extend two interfaces which is having same default method name 
then diamond problems occurs.
Which will occur in multiple inheritance of class.
to solve this problem in interface, check DiamondProblemSolution.java file.*/
class PrintmessageImpl1 implements Printmessage{//,PrintText{
	public static void msg() {
		Printmessage pm=new PrintmessageImpl1();
	    pm.print();
	}
	
}

public class DefaultMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintmessageImpl1.msg();
	}

}
package com.vsr.DefaultAndStaticMethods;


interface Printmessage1{
	default void print() {
		System.out.println("Hello \"Santhosh\'");
	}
}
interface PrintText1{
	default void print() {
		System.out.println("Hello \"Reddy\"");
	}
}

class PrintmessageImpl2 implements Printmessage1,PrintText1{
	/*public static void msg() {
		Printmessage1 pm=new PrintmessageImpl2();
	    pm.print();
	}*/
	//To solve diamond problem override default method in implementation class.
	/*public void print() {
		System.out.println("Hello \"Santhosh Reddy\"");
	}*/
  //if you want to execute interface logic only means you can override and use super keyword.
	public void print() {
		// TODO Auto-generated method stub
		PrintText1.super.print();
	}
	
	
}

public class DiamondProblemSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintmessageImpl2 l_objPrint=new PrintmessageImpl2();
		l_objPrint.print();
	}

}
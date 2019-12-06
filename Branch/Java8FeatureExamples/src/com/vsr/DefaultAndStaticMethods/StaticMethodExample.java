package com.vsr.DefaultAndStaticMethods;

interface Printer{
	static void printText() {
		System.out.println("Hello \"Reddy\"");
	}
}
class PrinterImpl implements Printer{
	public static void printText() {
		System.out.println("Hello \"Vaka\"");
	}
}
public class StaticMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer.printText();
        /*using parent reference for the object it is not possible to execute static methods 
		of interface.*/
		//Printer pt=new PrinterImpl();
		//pt.printText();
		PrinterImpl pt1=new PrinterImpl();//subclass object
		pt1.printText();
	}

}


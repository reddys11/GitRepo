package com.vsr.MethodReference;
interface Caluculator{
	public void add(int a,int b);
}
class CaluculatorImpl {//implements Caluculator{
	public void add(int a,int b) {
		System.out.println("Addition of two numbers==>"+(a+b));
	}
	
}
class CalInputs{
	public void feedInputs(int a,int b,Caluculator c) {
		c.add(a, b);
	}
}
public class MethodReferenceExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaluculatorImpl cal=new CaluculatorImpl();
		CalInputs l_objCI=new CalInputs();
		//l_objCI.feedInputs(10, 20,new CaluculatorImpl());
		l_objCI.feedInputs(10, 20,cal::add);
	}

}
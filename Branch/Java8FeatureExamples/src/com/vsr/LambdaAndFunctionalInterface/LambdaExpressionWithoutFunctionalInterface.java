package com.vsr.LambdaAndFunctionalInterface;
import com.vsr.functionalInterfaces.Caluculator;

public class LambdaExpressionWithoutFunctionalInterface {
	public static void main(String[] args){
		//Using Anonymous class
		Caluculator annymsCal=new Caluculator(){
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return (a+b);
			}
			
		};
		System.out.println(annymsCal.add(10,20));
	}
}
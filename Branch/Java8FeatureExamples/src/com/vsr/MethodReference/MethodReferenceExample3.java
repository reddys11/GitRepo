package com.vsr.MethodReference;
import java.util.Arrays;
import java.util.List;

interface PrintNumbers{
	public void add(int a,int b);
}
class PrintNumbersImpl {//implements Caluculator{
	public static void add(int a) {
		System.out.println("Addition of two numbers==>"+(a));
	}
	
}

public class MethodReferenceExample3 {

	public static void main(String[] args) {
		List<Integer> l_objList=Arrays.asList(0,5,10,15,20,25,30,35);
		l_objList.forEach(PrintNumbersImpl::add);
	}

}
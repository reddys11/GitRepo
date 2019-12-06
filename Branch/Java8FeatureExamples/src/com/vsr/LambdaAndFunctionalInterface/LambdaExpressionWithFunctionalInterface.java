package com.vsr.LambdaAndFunctionalInterface;

import com.vsr.functionalInterfaces.Caluculator;

public class LambdaExpressionWithFunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Caluculator l_objCal=(a,b)->{return (a+b);};
     System.out.println(l_objCal.add(20, 30));
	}

}

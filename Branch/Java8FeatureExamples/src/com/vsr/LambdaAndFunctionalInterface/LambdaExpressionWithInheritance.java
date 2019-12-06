package com.vsr.LambdaAndFunctionalInterface;

import com.vsr.functionalInterfaces.Caluculator;
import com.vsr.functionalInterfaces.CaluculatorInheritance;

public class LambdaExpressionWithInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//uncomment this line and uncomment the line interface also.
				//CaluculatorInheritance ctx= (a,b)->{return (a+b);}; 
				Caluculator ctx1= (a,b)->{return (a+b);};
				//System.out.println(ctx.add(10, 20));
				Caluculator.sub(20, 3);
				//ctx.mul(2,5);
	}

}

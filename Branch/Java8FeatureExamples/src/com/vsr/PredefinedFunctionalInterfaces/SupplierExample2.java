package com.vsr.PredefinedFunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierExample2 {

	public static void main(String[] args) {
		//Supplier=>Without i/p provide o/p.
     Supplier<EmployeeSupplier> l_objEmpSupp=()->{
    	 return new EmployeeSupplier(985,"Santhosh","Developer");
     };
	}

}

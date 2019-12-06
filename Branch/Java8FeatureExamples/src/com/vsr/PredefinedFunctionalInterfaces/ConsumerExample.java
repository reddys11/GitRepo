package com.vsr.PredefinedFunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		// Consumer will consume i/p but not return anything(return type is void).
		Consumer<String> c1=s->{if(s.length()>5) System.out.println("C1 Result::"+"Hello "+s);};
		c1.accept("Santhosh");
		Consumer<String> c2=s->System.out.println("C2 Result::"+s);
        c2.accept("Reddy");
        //Combine c1 and c2
        c1.andThen(c2).accept("Santhosh Reddy");
        
	}

}

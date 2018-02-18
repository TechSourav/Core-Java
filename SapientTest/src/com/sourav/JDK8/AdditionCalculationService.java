package com.sourav.JDK8;

public class AdditionCalculationService implements ICalculationService {

	@Override
	public int calculate(int first, int second) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return first + second;
	}

}

package com.sapient.sourav;

import java.util.Date;

public final class MyFinalClass {
	
	private final Integer immutableFiled;
	
	private final Date mutableField;
	
	MyFinalClass(Integer immutableFiled,Date mutableField){
		this.immutableFiled=immutableFiled;
		this.mutableField=new Date(mutableField.getTime());
	}

	public Integer getImmutableFiled() {
		return immutableFiled;
	}

	public Date getMutableField() {
		
		return new Date(mutableField.getTime());
		//return mutableField; // Not Recommended , since this is a mutable class and anyone can change the sate of it .
	}
	
	

}

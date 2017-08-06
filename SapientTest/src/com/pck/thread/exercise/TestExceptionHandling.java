package com.pck.thread.exercise;

public class TestExceptionHandling extends Exception {
	
	private String message;
	
	TestExceptionHandling(String msg){
		super(msg);
	}
	TestExceptionHandling(Throwable cause){
		super(cause);
	}
	TestExceptionHandling(String str,Throwable cause){
		super(str,cause);
	}


}

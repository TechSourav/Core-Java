package com.sourav.java.Stack;

import java.util.Stack;

public class EvaluatePostfix {
	
	public static void main(String[] args) {
		String exp="231*+9-";
        System.out.println(evaluatePostfix(exp));
	}
	
	static int evaluatePostfix(String exp) {
		Stack<Integer> s = new Stack<>();
		int result=0;
		for(int i=0;i<exp.length();i++) {
			char c= exp.charAt(i);
			if(Character.isDigit(c)) {
				s.push(Character.getNumericValue(c));
			}
			if(exp.charAt(i)=='+') {
				if(!s.isEmpty()) {
					int op1 = s.pop();
					int op2 = s.pop();
					s.push(op1+op2);
				}
			}
			if(exp.charAt(i)=='-') {
				if(!s.isEmpty()) {
					int op2 = s.pop();
					int op1 = s.pop();
					s.push(op1-op2);
				}
			}
			if(exp.charAt(i)=='*') {
				if(!s.isEmpty()) {
					int op2 = s.pop();
					int op1 = s.pop();
					s.push(op1*op2);
				}
			}
			if(exp.charAt(i)=='/') {
				if(!s.isEmpty()) {
					int op2 = s.pop();
					int op1 = s.pop();
					s.push(op2+op1);
				}
			}
		}
		return s.pop();
	}

}

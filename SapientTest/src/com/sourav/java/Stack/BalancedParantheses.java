package com.sourav.java.Stack;

import java.util.Stack;

public class BalancedParantheses {

	public static void main(String[] args) {
		String s1= "(A+(B+C))";
		String s2= "{A+(B+C)*(D+E)}";
		String s3= "(A+(B+C))}";
		String s4= "(A+{(B+C))";
		
		System.out.println(isbalanced(s1)?"true":"false");
		System.out.println(isbalanced(s2)?"true":"false");
		System.out.println(isbalanced(s3)?"true":"false");
		System.out.println(isbalanced(s4)?"true":"false");
	}
	
	static boolean isbalanced(String s) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(') {
				st.push(s.charAt(i));
			}
			if(s.charAt(i)==']' || s.charAt(i)=='}' || s.charAt(i)==')') {
				if(st.isEmpty()) {
					return false;
				}
				char c = st.pop();
				if(c=='[' && s.charAt(i)==']')
					continue;
				else if(c=='{' && s.charAt(i)=='}')
					continue;
				else if(c=='(' && s.charAt(i)==')')
					continue;
				else
					return false;
			}
		}
		return true;
	}
	

}

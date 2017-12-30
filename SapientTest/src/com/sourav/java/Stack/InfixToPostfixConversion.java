package com.sourav.java.Stack;

import java.util.Stack;

public class InfixToPostfixConversion {

	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	public static void main(String[] args) {

		String str = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(conversion(str));
	}

	static String conversion(String str) {
		Stack<Character> st = new Stack<>();
		String result = new String("");

		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				st.push(c);
			} else if (c == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					result += st.pop();
				}
				if (!st.isEmpty() && st.peek() != '(')
                    return "Invalid Expression"; // invalid expression                
                else
                    st.pop();
			} else {
				while (!st.isEmpty() && Prec(c) <= Prec(st.peek()))
					result += st.pop();
				st.push(c);
			}
			
		}

		while (!st.isEmpty())
			result += st.pop();

		return result;
	}
}

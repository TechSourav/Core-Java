package com.sapient.sourav;

public class TestBalanceParentheses {
	
	public static void main(String[] args){
		
		String str="A+[B*{C*D(F+H)}]";
		
		//Stack stk =new Stack(30);
		
		System.out.println(checkIfbalance(str));
		
	}
	
	static String checkIfbalance(String str){
		int length = str.length();
		Stack stk= new Stack(length+1);
		
		for(int i=0;i<=length-1;i++){
			char ch = str.charAt(i);
			if(ch=='[' || ch== '{' || ch=='('){
				stk.push(ch);
			}else if((ch==']' || ch== '}' || ch==')') && (!stk.isEmpty())){
				char peek =stk.peek();
				if((peek=='(' && ch==')') || (peek=='{' && ch=='}') || (peek=='[' && ch==']')){
					stk.pop();
				}else{
					System.out.println("Not Balanced!!");
				}
			}else {
				if ((ch == ']' || ch == '}' || ch == ')')) {
					return "Not Balanced";
				}
		}
		
		
	}
		
		if (stk.isEmpty())
			return "Balanced Parenthisis";
		else
			return "Not Balanced";
		
   }
}
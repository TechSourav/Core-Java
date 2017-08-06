package com.sourav.ANZ;

import java.io.IOException;
import java.util.Scanner;

public class HackerEarth1 {

	public static void main(String[] args) throws IOException {/*
		char ch ='a';
		if(Character.isLowerCase(ch)){
			char n =Character.toUpperCase(ch);
			System.out.println("Hi...."+ n);
		}

	*/
		// Solution 1
	
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println("Input word is = " + line);
        char[] charArray = line.toCharArray();
        for(int i=0;i<line.length();i++){
        	char ch=line.charAt(i);
        	if(Character.isLowerCase(ch))
        	  charArray[i] = Character.toUpperCase(ch);
        	if(Character.isUpperCase(ch))
        		charArray[i] = Character.toLowerCase(ch);
        }
        
        line=String.valueOf(charArray);
		System.out.println("New word is" + line);*/
        
		// Solution 2
		
		Scanner in = new Scanner(System.in);
		char[] str = new String(in.nextLine()).toCharArray();
		String a,b;
		
		System.out.println();
		
		for(int i=0;i<str.length;i++)
		{
			a = Character.toString(str[i]);
			b = a.toUpperCase();
			if(a.equals(b))
			{
				System.out.print(a.toLowerCase());
			}
			else
			{
				System.out.print(a.toUpperCase());
			}
		}
		
	
	}
	
}

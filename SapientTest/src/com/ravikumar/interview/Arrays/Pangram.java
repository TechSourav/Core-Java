package com.ravikumar.interview.Arrays;

import java.util.HashSet;
import java.util.Set;

class Pangram 
{
 
    // Returns true if the string
    // is pangram else false
    public static boolean checkPangram (String str)
    {
        // Create a hash table to mark the 
        // characters present in the string
        // By default all the elements of 
        // mark would be false.
        boolean[] mark = new boolean[26];
        
        // For indexing in mark[]
        int index = 0;
 
        // Traverse all characters
        for (int i = 0; i < str.length(); i++)
        {
            // If uppercase character, subtract 'A'
            // to find index.
            if ('A' <= str.charAt(i) && 
                    str.charAt(i) <= 'Z')
                         
                index = str.charAt(i) - 'A';
 
                // If lowercase character, subtract 'a'
                // to find index.
            else if('a' <= str.charAt(i) && 
                        str.charAt(i) <= 'z')
                             
                index = str.charAt(i) - 'a';
 
            // Mark current character
            mark[index] = true;
        }
 
        // Return false if any character is unmarked
        for (int i = 0; i <= 25; i++)
            if (mark[i] == false)
                return (false);
 
        // If all characters were present
        return (true);
    }
    
    private static void removeSpace(String s){
    	StringBuffer sb = new StringBuffer();
    	char[] str=s.toCharArray();
    	for(int i=0;i<s.length();i++){
    		if(str[i]!=' '&& (str[i] != '\t')){
    			sb.append(str[i]);
    		}
    	}
    	System.out.println(sb.toString());
    }
    
    private static void removeDuplicate(String s){
    	String stringWithDuplicates = "afsjeadrffafvgdefeverhfgberAAad";
    	char[] characters = stringWithDuplicates.toCharArray();
    	Set set=new HashSet();
    	StringBuilder sb = new StringBuilder();
    	System.out.println("String with duplicates : " + stringWithDuplicates);
    	for (char c : characters) {
    		if (!set.contains(c)) {
    		    set.add(c);
    		    sb.append(c);
    		}
    	}
    	System.out.println("String without duplicates : " + sb.toString());
    }
    
    private static void maxOccurringCharacter(String str){
    	/*int count =0;
    	str="geeksforgeeks";
    	char[] cArr= str.toCharArray();
    	int[] arr= new int[26];
    	for(char c: cArr){
    		if('A'<=c && c<='Z'){
    			int index = c-'A';
    			arr[index] ++; 
    		}
    		
    		if('a'<=c && c<='z'){
    			int index = c-'a';
    			arr[index] ++; 
    		}
    	}
    	int max = arr[0];
    	int c=0;
    	for(int i=1;i<arr.length;i++){
    		if(max<arr[i]){
    			max=arr[i];
    			c=i;
    		}
    	}
    	
    	System.out.println("Max ocurance " + c +" : " +max);*/
    	
    	int count[] = new int[256];
    	str="geeksforgeeks";
        // Construct character count array from the input
        // string.
        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;
      
        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result
      
        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("Max ocurance " + result);
    }
 
    // Driver Code
    public static void main(String[] args) 
    {
        String str = "The quick brown fox jumps over the lazy dog";
        
        removeSpace(str);
        removeDuplicate(str);
        maxOccurringCharacter(str);
 
        if (checkPangram(str) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str+ " is not a pangram.");
 
    }
}

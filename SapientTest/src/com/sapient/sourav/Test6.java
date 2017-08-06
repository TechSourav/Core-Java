package com.sapient.sourav;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentHashMap<Integer, Integer> treemap = new ConcurrentHashMap<Integer, Integer>(16,0.75f,32);
	      SortedMap<Integer, String> treemapincl = new TreeMap<Integer, String>();
	      //HashMap<Integer,Integer> treemap= new HashMap<Integer,Integer>();      
	      // populating tree map
	      
	      /*treemap.put(55, 100);
	      treemap.put(65, 700);
	      treemap.put(75, 890);
	      treemap.put(54, 180);
	      treemap.put(25, 180);
	      treemap.put(84, 180);
	      treemap.put(184, 1);
	      treemap.put(21, 1812);
	      treemap.put(2, 1878);
	      treemap.put(5, 184);
	      treemap.put(6, 185);
	      treemap.put(7, 186);
	      treemap.put(9, 187);
	      treemap.put(10, 184);
	      treemap.put(98, 183);
	      treemap.put(56, 182);
	      treemap.put(47, 181);
	      treemap.put(14, 150);
	      treemap.put(15, 190);
	      treemap.put(16, 580);
	      treemap.put(19, 380);
	      treemap.put(33, 280);*/
	      
	      
	      for(int i=0;i<240;i++){
	      
	    	  treemap.put(i, i+1);
	      
	      }
	      System.out.println("Getting original map" + treemap);
	     //int x=treemap.headMap(4).size();
	     // System.out.println("Tail map values: "+x);  
		
		
	}

}



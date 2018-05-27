package com.sourav.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestHashMap {

	public static void main(String[] args) {
		Map<String, Integer> gfg = new HashMap<String, Integer>();

		gfg.put("GFG", 28);
		gfg.put("Practice", 20);
		gfg.put("Code", 30);
		gfg.put("Quiz", 100);
		for (Map.Entry<String, Integer> entry : gfg.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		Map<String, Integer> map =sortByValue(gfg);
		System.out.println("\nAfer Sort by Value...");
		printmap(map);
		Map<String, Integer> map2=sortByKey(gfg);
		System.out.println("\nAfer Sort by Key...");
		printmap(map2);
	}

	private static void printmap(Map<String, Integer> gfg) {
		for (Map.Entry<String, Integer> entry : gfg.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> gfg) {

		Set<Map.Entry<String, Integer>> set = gfg.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		/*
		 * Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
		 * { public int compare( Map.Entry<String, Integer> o1,
		 * Map.Entry<String, Integer> o2 ) { return (o2.getValue()).compareTo(
		 * o1.getValue() ); } } );
		 */
		Comparator<Map.Entry<String, Integer>> com = Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed();
		Collections.sort(list, com);
		LinkedHashMap<String,Integer> lhm = new LinkedHashMap<String,Integer>();
		for(Map.Entry<String, Integer> m : list){
			lhm.put(m.getKey(), m.getValue());
		}
		return lhm;

	}
	private static Map<String, Integer> sortByKey(Map<String, Integer> gfg) {
		Set<Map.Entry<String, Integer>> set = gfg.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		TreeMap<String, Integer> treemap = new TreeMap<>(gfg);
		return treemap;
	}

}

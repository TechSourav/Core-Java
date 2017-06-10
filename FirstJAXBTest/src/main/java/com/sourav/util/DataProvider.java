package com.sourav.util;


import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sourav.Employee;

public class DataProvider {

	public static final String DATADIR = "src/main/java/data/";
	public static final int SMALL = 3;
	public static final int MEDIUM = 1000;
	
//	EmployeesLarge.xml isn't part of this project; to test
//	with a large data set copy the XML file from the DataProvider project and 
//	uncomment the following constant:
	
//	public static final int LARGE = 50000;

//	This method is just for testing
	public static void main(String[] args) {
		List<Employee> data = getData(SMALL);
		System.out.println("Returned: " + data.size());
		for (int i = 0; i < Math.min(data.size(), 10); i++) {
			System.out.println((Employee)data.get(i));
		}
	}
	
	public static List<Employee> getData(int limit) {
		
//		Decide which file to read from. 
//		Use 1000 record file for small or medium, 50,000 record file for large
		String filename = null;
		if (limit > MEDIUM) {
			filename = DATADIR + "EmployeesLarge.json";
		}
		else {
			filename = DATADIR + "Employees.json";
		}
		
//		Parse JSON file and get the data
		JSONArray inputData = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(new FileReader(filename));
			inputData = (JSONArray)obj.get("result");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return null;
		}

//		Create a List to contain typed objects
		List<Employee> outputData = new ArrayList<>();

//		Loop through the array up to requested limit,
//		copy JSON objects to ArrayList of POJO's
		for (int i = 0; i < limit; i++) {
			JSONObject item = (JSONObject)inputData.get(i);
			Employee emp = new Employee();
			
			emp.setId((Number)item.get(Employee.ID));
			emp.setName((String)item.get(Employee.EMP_NAME));
			emp.setAge((Number)item.get(Employee.EMP_AGE));
			emp.setSalary((Number)item.get(Employee.EMP_SALARY));
			
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			String joined = (String)item.get(Employee.EMP_DOJ);
			try {
				emp.setDoj(df.parse(joined));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}

			outputData.add(emp);
		}

//		All done, return the data
		return outputData;
	}

}

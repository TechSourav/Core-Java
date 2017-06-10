package com.sourav.ReadXml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sourav.Employee;
import com.sourav.Employees;

public class ReadXmlWithJaxb {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		Unmarshaller unm =context.createUnmarshaller();
		File f = new File("src/main/java/data/Employees.xml");
		Employees emp=(Employees)unm.unmarshal(f);
		List<Employee> emps= emp.getEmployee();
		for(Employee e:emps){
			System.out.println(e);
			
		}
	}

}
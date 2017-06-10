package com.sourav.jaxb;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sourav.Employee;
import com.sourav.Employees;
import com.sourav.util.DataProvider;

public class CreateXmlWithJaxb {
	
	public static void main(String[] args) throws JAXBException{
		List<Employee> data= DataProvider.getData(DataProvider.SMALL);
		
		Employees employees =new Employees();
		employees.setEmployee(data);
		
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		Marshaller marshaller=context.createMarshaller();
		marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		StringWriter sw= new StringWriter();
		marshaller.marshal(employees, sw);
		File f = new File("src/main/java/data/Employees.xml");
		marshaller.marshal(employees, f);
		System.out.println(sw.toString());
	}

}

package com.sourav;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
	
	@XmlElement(name="employee", type=Employee.class)
	private List<Employee> employees;

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}

}

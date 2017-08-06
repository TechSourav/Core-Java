package com.sourav.mock.Thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class TestClass {
	
	public static void main(String[] args) throws Exception{
		
		StudentSerialization ss = new StudentSerialization("Sourav" , "123");
		
		FileOutputStream fout = new FileOutputStream("File22.txt");
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(ss);
		oout.flush();
		oout.close();
		
		FileInputStream fot = new FileInputStream("File22.txt");
		ObjectInputStream oot = new ObjectInputStream(fot);
		
		StudentSerialization ss2 = (StudentSerialization) oot.readObject();
		oot.close();
		System.out.println(ss2.getName());
		System.out.println(ss2.getTempData());
		System.out.println(ss2.getPassword());
		
	}
	
}


class StudentSerialization implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String name;
	private String password;
	private transient String tempData="SouravK";
	
	StudentSerialization(String s, String pwd){
		this.name = s;
		this.password=pwd;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTempData() {
		return tempData;
	}
	public void setTempData(String tempData) {
		this.tempData = tempData;
	}
	
    private void readObject(ObjectInputStream oin) throws ClassNotFoundException, IOException {
      name = (String) oin.readObject();
      password = (String) oin.readObject();
      tempData = (String) oin.readObject();
      System.out.println("Ater de-serialization: " + name + " " + password + " " + tempData);
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
    	oos.defaultWriteObject();
    	oos.writeObject(name);
    	oos.writeObject(password);
    	oos.writeObject(tempData);
    	
    }

}



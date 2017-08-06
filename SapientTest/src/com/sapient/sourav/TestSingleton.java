package com.sapient.sourav;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Singleton s = Singleton.getInstance();
		
		Class<?> cls = Class.forName("com.sapient.sourav.Singleton");
		Constructor<?> cons= cls.getDeclaredConstructor();
		cons.setAccessible(true);
		Singleton s2 =  (Singleton) cons.newInstance();
	}
	
}

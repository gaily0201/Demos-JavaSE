package com.zyg.jpa.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parse {
	
	public void parse(Object obj,String methodName){
		Method[] ms = obj.getClass().getMethods();
		for(Method m:ms){
			if(m.getName().equals(methodName)){
				if(m.isAnnotationPresent(NewHelloWorld.class)){
					NewHelloWorld hw = m.getAnnotation(NewHelloWorld.class);
					//System.out.println(hw.value());
					try {
						System.out.println("before....");
						m.invoke(obj, null);
						System.out.println("after....");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

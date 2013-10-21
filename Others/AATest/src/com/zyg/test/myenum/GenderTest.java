package com.zyg.test.myenum;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;

public class GenderTest {

	/**   
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(
				BeanUtils.getProperty(Gender.MAN, "title")
		);

		/*Object bean = Gender.MAN;
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(bean.getClass());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor property:properties)
		{
			if(property.getName().equals("title"))
			{
				Method method = property.getReadMethod();
				//值得研究
				//System.out.println(method.isAccessible());
				method.setAccessible(true);
				Object retVal;
				try {
					retVal = method.invoke(bean, null);
    				System.out.println(retVal);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}				*/
	}

}

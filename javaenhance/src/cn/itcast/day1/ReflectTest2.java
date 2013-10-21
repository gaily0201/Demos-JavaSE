package cn.itcast.day1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

public class ReflectTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*getRealPath();//金山词霸/内部
		一定要记住用完整的路径，但完整的路径不是硬编码，而是运算出来的。*/
		//InputStream ips = new FileInputStream("config.properties");
		
		//InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("cn/itcast/day1/config.properties");
		//InputStream ips = ReflectTest2.class.getResourceAsStream("resources/config.properties");
		InputStream ips = ReflectTest2.class.getResourceAsStream("/cn/itcast/day1/resources/config.properties");

		Properties props = new Properties();
		props.load(ips);
		ips.close();
		String className = props.getProperty("className");
		Collection collections = (Collection)Class.forName(className).newInstance();
		
		//Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3,3);
		ReflectPoint pt2 = new ReflectPoint(5,5);
		ReflectPoint pt3 = new ReflectPoint(3,3);	

		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);	
		
		//pt1.y = 7;		
		//collections.remove(pt1);
		
		System.out.println(collections.size());
	}

}

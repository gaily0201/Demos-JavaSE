package com.cn.comm;

import java.io.File;
import java.net.URISyntaxException;


/**
 * <p>
 * Title: Tools
 * Description: 字符串处理公共组件
 * Copyright: Copyright (c) 2007
 * Company: huawei technology Co. Ltd
 * @author pyj
 * @version 1.0
 */

public class Tools {
	/**
	 * 判断字符串是否为空
	 * @param o
	 * @return boolean
	 */
	public static boolean isEmpty(Object str) {
		if (null == str || "".equals(str) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 空对象处理
	 */
	public static String checkNull(Object ob) {
		if ((null == ob) || ("null".equals(ob)) || ("".equals(ob))) {
			return "";
		} else {
			return ob.toString();
		}
	}
	
	public static void logToControl(String outMode, Object outInfo) {
		// 传入ERR则打印红色字体调试信息
		if ("err".equals(outMode)) {
			System.err.println(outInfo);
		} else {
			 System.out.println(outInfo);
		}
	}
	/*
	 * 得到工程路径：java工程路径
	 */
	public static String getClassPath() {
		String path = "";
		try {
			path = System.getProperty("user.dir");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return path;
	}
	

	
	 // 得到ClassPath的绝对路径:web 工程classes路径
    public static String getWebClassPath() {
        String result = null;
        try {
            File file = new File(Tools.class.getClassLoader().getResource("/").toURI());
            result = file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取web工程路径：
    public static String getWebPath() {
    	 String s=getWebClassPath();
    	 String m=rLeft(s, "WEB-INF");
    	 return m;
    }
    
   
    
	
	/**
	 * 中文转换
	 * 
	 * @param tmpStr
	 *            string
	 * @return string
	 */
	public static String toChinese(String strvalue) {
		try {
			if (null == strvalue)
				return "";
			else {
				strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}

	}
	/*
	 * 字符串替换方法：区分大小写
	 * @param sourceStr String 原始字符串
	 * @param oldString String 要被替换的字符串 @param newString String 替换的字符串 @return
	 * String 返回替换后的字符串
	 * replaceStr("1234K5678","K","8888");123488885678
	 */

	public static final String replaceStr1(String sourceStr, String oldString, String newString) {
		if (null == sourceStr) {
			return null;
		}

		int i = 0;
		if ((i = sourceStr.indexOf(oldString, i)) >= 0) {
			char[] line2 = sourceStr.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = sourceStr.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return sourceStr;
	}

	
	/*
	 * 从右边向左取分隔符左边的值
	 * 
	 * 
	 * 
	 * @param source原始文本 @param sep分隔符
	 * 
	 * 
	 * 
	 * rLeft("1234K5678","K");1234
	 */
	public static String rLeft(String source, String sep) {
		source = source.toLowerCase();
		sep = sep.toLowerCase();
		String retstr = "";
		int len = source.length();
		int len1 = sep.length();
		int len2 = len - len1;
		for (int i = len2 - 1; i >= 0; i--) {
			if (source.substring(i, i + len1).equals(sep)) {
				retstr = source.substring(0, i);
				break;
			}
		}
		return retstr;
	}
	
	/*
	 * 从右边向左取分隔符右边的值
	 * 
	 * @param source原始文本 @param sep分隔符
	 * 
	 * rRight("1234K5678","K");5678
	 */
	public static String rRight(String source, String sep) {
		source = source.toLowerCase();
		sep = sep.toLowerCase();
		String retstr = "";
		int len = source.length();
		int len1 = sep.length();
		int len2 = len - len1;
		for (int i = len2 - 1; i >= 0; i--) {
			if (source.substring(i, i + len1).equals(sep)) {
				retstr = source.substring(i + len1, len);
				break;
			}
		}
		return retstr;
	}
	
	public static void main(String args[])
	{
		
		
		
		String s= "E:\\workproject\\JspXMLProject\\WebRoot\\WEB-INF\\classes";
		String m=rLeft(s, "Webroot");
		System.out.println("m=="+m);
		
		
		
		
	}
}

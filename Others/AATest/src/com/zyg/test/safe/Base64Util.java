package com.zyg.test.safe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import sun.misc.BASE64Encoder;

public class Base64Util {

	/**
	 * @param args add by zxx ,Dec 30, 2008
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println("please input user name:");
		String username = new BufferedReader(
					new InputStreamReader(System.in))
					.readLine();
		System.out.println(encoder.encode(username.getBytes()));
		System.out.println("please input password:");
		String password = new BufferedReader(
				new InputStreamReader(System.in))
				.readLine();		
		System.out.println(encoder.encode(password.getBytes()));
		

	}
	

}

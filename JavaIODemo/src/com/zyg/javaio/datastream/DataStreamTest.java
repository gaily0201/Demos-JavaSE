package com.zyg.javaio.datastream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStreamTest {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStreamTest tst = new DataStreamTest();
		
		tst.test();
	}

	public void test(){
		ByteArrayOutputStream baos = null;
		DataOutputStream dos = null;
		
		ByteArrayInputStream bais = null;
		DataInputStream dis = null;
		
		try {
			//输出流
			baos = new ByteArrayOutputStream();
			dos = new DataOutputStream(baos);
			//将数据写出到内存中
			dos.writeDouble(new Double(3));
			dos.writeBoolean(true);
			baos.close();
			dos.close();
			
			//输入流
			bais = new ByteArrayInputStream(baos.toByteArray());
			dis = new DataInputStream(bais);
			
			System.out.println("读入数据如：");
			
			/*for(int i=0;i<8;i++){
				System.out.println(dis.readBoolean());
			}*/
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			bais.close();
			dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}
}

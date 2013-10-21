package com.zyg.junit.test;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * junit3.8�в��������̳�Test����
 * @author Administrator
 * keep the bar green to keep the code clean!!
 * 
 * ��Ԫ���Բ���֤�����ǶԵģ�����֤����û�д��󣡣���
 */
public class CalculatorTest extends TestCase{
	/**
	 * junit3.8�в��Է�����Ҫ��������ԭ��
	 * 1.public 
	 * 2.void
	 * 3.�޷�������
	 * 4.�������Ʊ�����test��ͷ
	 */
	
	private Calculator cal;
//	protected void setUp() throws Exception {};
	@Override

	//��дsetup����
	public void setUp(){
		//System.out.println("hello!");
		cal = new Calculator();
	}
	
	/*protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}*/
	
	//��дtearDown
	public void tearDown(){
		//System.out.println("welcome!");
	}
	
	
	public void testAdd(){
		//Calculator cal = new Calculator();
		int result  = cal.add(1, 2);
		
		//����
		Assert.assertEquals(3,result);
	}
	
	public void testMinus(){
		//Calculator cal = new Calculator();
		int result = cal.minus(1, 2);
		Assert.assertEquals(-1, result);
	}
	
	public void testMultiply(){
		//Calculator cal = new Calculator();
		int result = cal.multiply(2, 3);
		
		//����
		Assert.assertEquals(6, result);
	}
	
	public void testDivide(){
		//Calculator cal = new Calculator();
		int result = 0;
		try {
			result = cal.divide(6, 4);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		//����
		Assert.assertEquals(1,result);
	}
	
/*	public void testDivide2(){
		Throwable tx = null;
		try{
			//Calculator cal = new Calculator();
			cal.divide(4, 1);
			
			Assert.fail();
		}catch(Exception ex){
			tx = ex;
		}
		System.out.println(tx.getMessage());
		Assert.assertNotNull(tx);
		Assert.assertEquals(Exception.class, tx.getClass());
		Assert.assertEquals("��������Ϊ�㣡��",tx.getMessage());
	}*/
}

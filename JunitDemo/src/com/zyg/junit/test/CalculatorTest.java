package com.zyg.junit.test;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * junit3.8中测试类必须继承Test父类
 * @author Administrator
 * keep the bar green to keep the code clean!!
 * 
 * 单元测试不是证明您是对的，而是证明您没有错误！！！
 */
public class CalculatorTest extends TestCase{
	/**
	 * junit3.8中测试方法需要满足以下原则
	 * 1.public 
	 * 2.void
	 * 3.无方法参数
	 * 4.方法名称必须以test开头
	 */
	
	private Calculator cal;
//	protected void setUp() throws Exception {};
	@Override

	//重写setup方法
	public void setUp(){
		//System.out.println("hello!");
		cal = new Calculator();
	}
	
	/*protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}*/
	
	//重写tearDown
	public void tearDown(){
		//System.out.println("welcome!");
	}
	
	
	public void testAdd(){
		//Calculator cal = new Calculator();
		int result  = cal.add(1, 2);
		
		//断言
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
		
		//断言
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
		
		//断言
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
		Assert.assertEquals("除数不能为零！！",tx.getMessage());
	}*/
}

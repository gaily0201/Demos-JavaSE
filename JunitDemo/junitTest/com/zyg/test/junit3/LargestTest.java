package com.zyg.test.junit3;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LargestTest extends TestCase {
	
	private Largest largest;
	public void setUp(){
		largest = new Largest();
	}
	
	public void testGetLargest(){
		int[] array = {1,2,4,9,10};
		int result = 0;
		try {
			result = largest.getLargest(array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertEquals(10, result);
	}
	
	public void testGetLargest2(){
		Throwable tx = null;
		int[] array = {};
		try {
			largest.getLargest(array);
		} catch (Exception e) {
			e.printStackTrace();
			tx = e;
		}
		
		Assert.assertNotNull(tx);
		Assert.assertEquals(Exception.class, tx.getClass());
		Assert.assertEquals("数组不能为空！", tx.getMessage());
	}
	
	public void testGetLargest3(){
		Throwable tx = null;
		try {
			int[] array = null;
			largest.getLargest(array);
		} catch (Exception e) {
			tx = e;
			e.printStackTrace();
		}
		
		Assert.assertNotNull(tx);
		Assert.assertEquals(Exception.class, tx.getClass());
		Assert.assertEquals("数组不能为空！", tx.getMessage());
	}
}

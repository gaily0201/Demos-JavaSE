package com.zyg.junit.test;

public class Largest {

	public int getLargest(int[] array) throws Exception {
		
		if (null == array || 0 == array.length) {
			throw new Exception("数组不能为空！");
		}

		int result = array[0];
		for (int i = 0; i < array.length; ++i) {
			if (result < array[i]) {
				result = array[i];
			}
		}
		return result;
	}
}

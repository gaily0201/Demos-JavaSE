package com.zyg.dp.facadedp3;

public class Test {

	
	public static void main(String[] args) {
		//1.�Һ�
		GuaHaoJieDai ghjd=new GuaHaoJieDai();
		ghjd.satrt();
		
		//2.����
		JiuZhenJieDai jzjd=new JiuZhenJieDai();
		jzjd.start();
		
		//3.����
		HuaYanJieDai hyjd=new HuaYanJieDai();
		hyjd.satrt();
		
		//4.ȡҩ
		QuYaoJieDai qyjd=new QuYaoJieDai();
		qyjd.start();

	}

}

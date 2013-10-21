package com.zyg.dp.facadedp3;

public class Test {

	
	public static void main(String[] args) {
		//1.挂号
		GuaHaoJieDai ghjd=new GuaHaoJieDai();
		ghjd.satrt();
		
		//2.就诊
		JiuZhenJieDai jzjd=new JiuZhenJieDai();
		jzjd.start();
		
		//3.化验
		HuaYanJieDai hyjd=new HuaYanJieDai();
		hyjd.satrt();
		
		//4.取药
		QuYaoJieDai qyjd=new QuYaoJieDai();
		qyjd.start();

	}

}

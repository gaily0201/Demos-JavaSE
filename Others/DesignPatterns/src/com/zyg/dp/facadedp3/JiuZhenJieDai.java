package com.zyg.dp.facadedp3;
//就诊系统的门面
public class JiuZhenJieDai {
	public final static JiuZhen jz=new JiuZhen();
	
	public void start(){
		jz.start();
		jz.huaYan();
	}
}

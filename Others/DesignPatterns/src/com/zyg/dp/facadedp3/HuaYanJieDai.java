package com.zyg.dp.facadedp3;
//化验系统的门面
public class HuaYanJieDai {
	public final static HuaYan hy=new HuaYan();
	
	public void satrt(){
		hy.jiaoFei();
		hy.satrt();
		hy.over();
	}
}

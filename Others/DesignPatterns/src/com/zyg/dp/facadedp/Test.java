package com.zyg.dp.facadedp;

public class Test {


	public static void main(String[] args) {
		//1. 挂号
		GuaHao gh=new GuaHao();
		gh.start();
		gh.over();
		
		//2.去门诊
		JiuZhen jz=new JiuZhen();
		jz.start();
		jz.huaYan();
		
		//3.去化验
		HuaYan hy=new HuaYan();
		hy.jiaoFei();
		hy.satrt();
		hy.over();
		
		//4.去拿药
		QuYao qy=new QuYao();
		qy.jiaoFei();
		qy.start();
		qy.over();
	}

}

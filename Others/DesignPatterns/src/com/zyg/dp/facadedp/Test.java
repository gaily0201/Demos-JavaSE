package com.zyg.dp.facadedp;

public class Test {


	public static void main(String[] args) {
		//1. �Һ�
		GuaHao gh=new GuaHao();
		gh.start();
		gh.over();
		
		//2.ȥ����
		JiuZhen jz=new JiuZhen();
		jz.start();
		jz.huaYan();
		
		//3.ȥ����
		HuaYan hy=new HuaYan();
		hy.jiaoFei();
		hy.satrt();
		hy.over();
		
		//4.ȥ��ҩ
		QuYao qy=new QuYao();
		qy.jiaoFei();
		qy.start();
		qy.over();
	}

}

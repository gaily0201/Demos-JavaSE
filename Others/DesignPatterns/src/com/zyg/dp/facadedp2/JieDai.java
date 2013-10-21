package com.zyg.dp.facadedp2;

public class JieDai {
	public final static GuaHao gh=new GuaHao();
	public final static JiuZhen jz=new JiuZhen();
	public final static HuaYan hy=new HuaYan();
	public final static QuYao qy=new QuYao();
	
	public void start(){
		gh.start();
		gh.over();
		
		jz.start();
		jz.huaYan();
		
		hy.jiaoFei();
		hy.satrt();
		hy.over();
		
		qy.jiaoFei();
		qy.start();
		qy.over();
	}
}

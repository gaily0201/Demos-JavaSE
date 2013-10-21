package com.zyg.dp.facadedp3;
//挂号系统的门面
public class GuaHaoJieDai {
	public final static GuaHao gh=new GuaHao();
	
	public void satrt(){
		gh.start();
		gh.over();
	}
}

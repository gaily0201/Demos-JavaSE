package com.ttd.test;

//���һ��ʱ��ֵ��
public class Pair {
	String from ;
	String to;
	
	Pair(String from,String to){
		this.from = from;
		this.to = to;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair)obj;
		return from.equals(p.from) && to.equals(p.to);
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}

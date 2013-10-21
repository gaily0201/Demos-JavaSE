package com.zyg.test.myenum;

public enum Gender {
	MAN{
		public String getTitle(){return "男";}		
	},
	WOMAN{
		public String getTitle(){return "女";}			
	},
	BOTH{
		public String getTitle(){return "男女均可";}			
	};
	public abstract String getTitle();
	public String getValue()
	{
		return this.name();
	}
}

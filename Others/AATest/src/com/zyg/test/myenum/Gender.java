package com.zyg.test.myenum;

public enum Gender {
	MAN{
		public String getTitle(){return "��";}		
	},
	WOMAN{
		public String getTitle(){return "Ů";}			
	},
	BOTH{
		public String getTitle(){return "��Ů����";}			
	};
	public abstract String getTitle();
	public String getValue()
	{
		return this.name();
	}
}

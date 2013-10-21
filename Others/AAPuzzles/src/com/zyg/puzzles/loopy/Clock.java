package com.zyg.puzzles.loopy;

public class Clock {
	
	public static void main(String[] args) {
		int minutes = 0;
		for (int ms = 0; ms < 60*60*1000; ms++)
		/*if (ms % 60*1000 == 0){
			minutes++;
		}*/
			
		//解决方案1
		if (ms % (60*1000) == 0){
			minutes++;
		}
		System.out.println(minutes);
	}
	
	//解决方案2
	/*private static final int MS_PER_HOUR = 60 * 60 * 1000;
	private static final int MS_PER_MINUTE = 60 * 1000;

	public static void main(String[] args) {
		int minutes = 0;
		for (int ms = 0; ms < MS_PER_HOUR; ms++)
			if (ms % MS_PER_MINUTE == 0)
				minutes++;
		System.out.println(minutes);
	}*/
}

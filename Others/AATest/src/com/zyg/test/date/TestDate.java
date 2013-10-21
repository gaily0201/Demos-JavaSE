package com.zyg.test.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Map> years = new ArrayList();
		for(int i=0;i<9;i++){
			Map year = new HashMap();
			year.put("dd", i);
			years.add(year);
		}
		
		for(Map m : years){
			System.out.println(m.get("dd"));
		}
	}

}

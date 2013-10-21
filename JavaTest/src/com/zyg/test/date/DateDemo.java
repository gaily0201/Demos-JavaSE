/*
 * ���������������� 2008-08-29 ��2008-09-02 
	��ʲô�������Է�����������֮���ÿһ�죬���������2008-08-29��
	2008-08-30��2008-08-31��2008-09-01��2008-09-02
 */

package com.zyg.test.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws Exception {
        Date start = new SimpleDateFormat("yyy-MM-dd").parse("2008-08-29");
        Date end = new SimpleDateFormat("yyy-MM-dd").parse("2008-09-02");
        
//        start = new Date(start.getTime() + 86400000);
        
        while(start.getTime() <= end.getTime()){
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(start));
            start = new Date(start.getTime() + 86400000);
        }
        
    }
}

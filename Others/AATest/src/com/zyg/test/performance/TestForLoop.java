package com.zyg.test.performance;

/**  
 * ȫ�����Ƕ�׶��Forѭ�������ܡ�  
 *   
 * @author ������ļ�(laozizhu.com)  
 *   
 */  
public class TestForLoop {   
  public static void main(String[] args) {   
     int small =  1;   
     int middle = 1000;   
     int large =  1000000;   
    // ��ѭ�������棬Сѭ�������棬����ÿ������   
    long t = System.currentTimeMillis();   
    for (int i = 1; i <= large; i++) {   
      for (int j = 1; j <= middle; j++) {   
        for (int k = 1; k <= small; k++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // ��ѭ�������棬Сѭ�������棬����ͳһ����   
    t = System.currentTimeMillis();   
    int i, j, k;   
    for (i = 1; i <= large; i++) {   
      for (j = 1; j <= middle; j++) {   
        for (k = 1; k <= small; k++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // Сѭ�������棬��ѭ�������棬����ÿ������   
    t = System.currentTimeMillis();   
    for (int kk = 1; kk <= small; kk++) {   
      for (int jj = 1; jj <= middle; jj++) {   
        for (int ii = 1; ii <= large; ii++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // Сѭ�������棬��ѭ�������棬����ͳһ����   
    t = System.currentTimeMillis();   
    int ii, jj, kk;   
    for (kk = 1; kk <= small; kk++) {   
      for (jj = 1; jj <= middle; jj++) {   
        for (ii = 1; ii <= large; ii++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
  }   
}  


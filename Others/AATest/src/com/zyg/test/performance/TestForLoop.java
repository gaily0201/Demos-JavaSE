package com.zyg.test.performance;

/**  
 * 全面测试嵌套多层For循环的性能。  
 *   
 * @author 老紫竹的家(laozizhu.com)  
 *   
 */  
public class TestForLoop {   
  public static void main(String[] args) {   
     int small =  1;   
     int middle = 1000;   
     int large =  1000000;   
    // 大循环在外面，小循环在里面，变量每次生成   
    long t = System.currentTimeMillis();   
    for (int i = 1; i <= large; i++) {   
      for (int j = 1; j <= middle; j++) {   
        for (int k = 1; k <= small; k++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // 大循环在外面，小循环在里面，变量统一生成   
    t = System.currentTimeMillis();   
    int i, j, k;   
    for (i = 1; i <= large; i++) {   
      for (j = 1; j <= middle; j++) {   
        for (k = 1; k <= small; k++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // 小循环在外面，大循环在里面，变量每次生成   
    t = System.currentTimeMillis();   
    for (int kk = 1; kk <= small; kk++) {   
      for (int jj = 1; jj <= middle; jj++) {   
        for (int ii = 1; ii <= large; ii++) {   
        }   
      }   
    }   
    System.out.println(System.currentTimeMillis() - t);   
    // 小循环在外面，大循环在里面，变量统一生成   
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


package com.zyg.junit.test;

import junit.framework.*;
import junit.extensions.TestSetup;

public class AllTestsOneTimeSetup {

    public static Test suite() {

        TestSuite suite = new TestSuite();

        suite.addTestSuite(TestCar.class);
        
//        suite.addTest(AnotherTest.suite());

        TestSetup wrapper = new TestSetup(suite) {

            protected void setUp() {
                oneTimeSetUp();
            }

            protected void tearDown() {
                oneTimeTearDown();
            }
        };

        return wrapper;
    }

    public static void oneTimeSetUp() {
    	System.out.println("�����ݿ����ӡ�������������������");
        // one-time initialization code
    }

    public static void oneTimeTearDown() {
    	System.out.println("�ر����ݿ����ӡ�������������������");
        // one-time cleanup code
    }
}


package junit.framework;

/**
 * A Listener for test progress
 * 在JUnit框架中有两个类实现了这个接口，一个负责结果打印的ResultPrinter类
 * ，一个是所有TestRunner的基础类BaseTestRunner类（这两个类都不在framework包中）。 
 */
public interface TestListener {
	/**
 	 * An error occurred.
 	 */
	public void addError(Test test, Throwable t);
	/**
 	 * A failure occurred.
 	 */
 	public void addFailure(Test test, AssertionFailedError t);  
	/**
	 * A test ended.
	 */
 	public void endTest(Test test); 
	/**
	 * A test started.
	 */
	public void startTest(Test test);
}
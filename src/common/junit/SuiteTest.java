package common.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;

//测试套件类 相当于测试类的集合
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class SuiteTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for common.junit");
		//$JUnit-BEGIN$

		//$JUnit-END$
		return suite;
	}

}

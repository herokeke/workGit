package common.classUtil.webService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Yongfeng Zhai
 * @version 1.0.0
 */
public class CxfClientTest {
	private static Logger logger = LogManager.getLogger(CxfClientTest.class);

	public static void main(String[] args) {

		String wsdlURL = Util.getProperty("wsdlURL");
		wsdlURL="http://localhost:9000/HelloWorld?wsdl";
		logger.info("wsdlURL:" + wsdlURL);
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setWsdlURL(wsdlURL);
		factoryBean.setServiceClass(HelloWorldImpls.class);

		IHelloWorlds service = (IHelloWorlds) factoryBean.create();

		String xml = Util.getProperty("xml");
		logger.info("xml:" + xml);

		String result = service.sayHi("sssssssssss");

		logger.info("result:" + result);
	}
}

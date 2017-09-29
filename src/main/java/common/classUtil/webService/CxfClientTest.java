package common.classUtil.webService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author Yongfeng Zhai
 * @version 1.0.0
 */
public class CxfClientTest {

	public static void main(String[] args) {

		String wsdlURL = Util.getProperty("wsdlURL");
		wsdlURL="http://localhost:9000/HelloWorld?wsdl";
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setWsdlURL(wsdlURL);
		factoryBean.setServiceClass(HelloWorldImpls.class);

		IHelloWorlds service = (IHelloWorlds) factoryBean.create();

		String xml = Util.getProperty("xml");

		String result = service.sayHi("sssssssssss");

	}
}

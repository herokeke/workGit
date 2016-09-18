package common.classUtil.webService;

import java.util.Vector;



/**
 * ����axis1��д��ͨ�ÿͻ��ˣ����Ե����������͵�webservice�����
 * 
 * @author Yongfeng Zhai
 * @version 1.0.0
 * @see com.ceb.tosp.ls.cxfws.client.DynamicClientFactory
 */
public class Axis1ClientTest {


	public static void main(String[] args) throws Exception {
		String wsdlURL = Util.getProperty("wsdlURL");
		String serviceName = Util.getProperty("serviceName");
		String portName = Util.getProperty("portName");
		String methodName = Util.getProperty("methodName");
		String timeout = Util.getProperty("timeout");
		int timeoutValue = Integer.valueOf(timeout);
		String xml = Util.getProperty("xml");
		DynamicClientFactory factory = new DynamicClientFactory(wsdlURL);
		Vector<String> params = new Vector<String>();
		params.add(xml);
		String result = (String) factory.invoke(serviceName, portName, methodName, params, timeoutValue);
	}
}

package common.classUtil.webService;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.xfire.client.Client;

public class XfireClientTest {

	private static Logger logger = LogManager.getLogger(XfireClientTest.class);

	public static void main(String[] args) {

		String wsdlURL = Util.getProperty("wsdlURL");
		String xml = Util.getProperty("xml");
		logger.info("wsdlURL:" + wsdlURL);
		logger.info(xml);

		Client client = null;
		try {
			client = new Client(new URL(wsdlURL));
			logger.info("client:" + client);
			Object[] result = client.invoke("sendMessage", new Object[] { xml });
			logger.info("result:" + result[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

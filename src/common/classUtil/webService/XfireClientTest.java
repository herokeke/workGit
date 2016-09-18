package common.classUtil.webService;

import java.net.URL;

import org.codehaus.xfire.client.Client;

public class XfireClientTest {


	public static void main(String[] args) {

		String wsdlURL = Util.getProperty("wsdlURL");
		String xml = Util.getProperty("xml");

		Client client = null;
		try {
			client = new Client(new URL(wsdlURL));
			Object[] result = client.invoke("sendMessage", new Object[] { xml });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

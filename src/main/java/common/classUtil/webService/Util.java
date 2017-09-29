package common.classUtil.webService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

public class Util {

	public static Properties property;
	
	static {
		InputStream inStream = null;
		try {
			URI uri = Util.class.getResource("/tosp.properties").toURI();
			File file = new File(uri);
			inStream = new FileInputStream(file);
			property = new Properties();
			property.load(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inStream!=null)
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static String getProperty(String key) {
		return property.getProperty(key);
	}
}

package common.classUtil.EhCache;

import org.junit.Test;

import net.sf.ehcache.CacheManager;

public class EhCacheTest {
	
	
	@Test
	public void testEhCache(){
		CacheManager manager = CacheManager.create("src\\common\\classUtil\\EhCache\\ehcache.xml");
	
	}
	
}

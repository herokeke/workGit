package common.classUtil.EhCache;

import java.io.Serializable;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheTest {
	private Cache cache;
	private static EhcachSerializable es;
	
	@BeforeClass
	public static void init(){
		  es = new EhcachSerializable();
	}
	
	@Before
	public void putCache(){
		 CacheManager manager = CacheManager.create("src\\common\\classUtil\\EhCache\\ehcache.xml");
		 cache =  manager.getCache("UserEhcache");
		 System.out.println("缓存的Element数量="+cache.getSize()); //  获取指定缓存的Element数量
		 System.out.println("缓存在内存中的Element数量="+cache.getMemoryStoreSize());//获取指定缓存在内存中的Element数量
		 System.out.println("缓存状态="+cache.getStatus());//获取缓存状态
		 System.out.println("缓存在磁盘中的Element数量="+cache.getDiskStoreSize());//获取指定缓存在磁盘中的Element数量
			List<Object> keys = cache.getKeys(); //获取缓存Element集合
			for (Object key : keys) {
			   System.out.println("key="+key);
			}
			//使用cache.flush()，每次写入到cache后调用cache.flush() ，这样ehcache 会将索引（xxx.index）回写到磁盘。这样就不用担心程序是否非正常退出导致缓存丢失了。
			cache.flush();
	}
	
	@Test
	public void testEhCache0(){
		   cache.remove("key");   
		   Element elem = new Element("key", "EhCacheValue");   
	       cache.put(elem); 
	       
		  
	}

	@Test
	public void testEhCache1(){
		   Element element = cache.get("key");   
		   if(element!=null && !cache.isExpired(element)){// isExpired 是否过期
                Object value =  element.getObjectValue();  
                 System.out.println(value);
            } 
	}
	
	@Test
	public void testEhCache2(){
		   cache.remove(es);   
		   Element elem = new Element(es,"EhCacheValueSerializable");   
	       cache.put(elem); 
	}
	@Test
	public void testEhCache3(){
		   Element element = cache.get(es);   
		   if(element!=null && !cache.isExpired(element)){// isExpired 是否过期
             Object value =  element.getValue();  
              System.out.println("SerializableValue="+value);
            } 
	}
	
}

class EhcachSerializable implements Serializable{
	public String name;

}

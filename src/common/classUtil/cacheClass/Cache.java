package common.classUtil.cacheClass;

/**
 * 缓存实例的不可改变类
 * @author Administrator
 *
 */
public class Cache{
	public static void main(String[] args){
		CacheImmutale c0 =CacheImmutale.valueOf("hero0");
		System.out.println("=====");
		CacheImmutale c1 =CacheImmutale.valueOf("hero1");
		System.out.println("=====");
		CacheImmutale c2 =CacheImmutale.valueOf("hero2");
		System.out.println("=====");
		CacheImmutale c3 =CacheImmutale.valueOf("hero3");
		System.out.println("=====");
		CacheImmutale c4 =CacheImmutale.valueOf("hero4");
		System.out.println("=====");
		CacheImmutale c5 =CacheImmutale.valueOf("hero5");
		System.out.println("=====");
		CacheImmutale c6 =CacheImmutale.valueOf("hero6");
		System.out.println("=====");
		CacheImmutale c7 =CacheImmutale.valueOf("hero7");
		System.out.println("=====");
		CacheImmutale c8 =CacheImmutale.valueOf("hero8");
		System.out.println("=====");
		CacheImmutale c9 =CacheImmutale.valueOf("hero9");
		System.out.println("=====");
		CacheImmutale c10 =CacheImmutale.valueOf("hero10");
		System.out.println("=====");
		
		
		
	}
}
class CacheImmutale{
	private final String name;
	private static int pos=0;
	private static CacheImmutale[] cache =new CacheImmutale[5];
	public CacheImmutale(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public static CacheImmutale valueOf(String name){
		for(int i =0; cache!=null&&i<=cache.length-1;i++){
			System.out.print(cache[i]+"<=>");
			
		}
		 for(int i=0;i<pos;i++){
			 if(cache[i]!=null && cache[i].getName().equals(name)){
				 return cache[i];
			 }
		 }
		 if(pos==5){
			 cache[0] = new CacheImmutale(name);
			 pos=1;
			 return cache[0];
		 }else{
			 cache[pos++] = new CacheImmutale(name);
			 return cache[pos-1];
		 }
	}
	public boolean equals(Object obj){
		if(this==obj){ 
			return true;
		}
		if(obj instanceof CacheImmutale){
			CacheImmutale cache = (CacheImmutale)obj;
			if(name.equals(cache.getName())){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return name.hashCode();
	}
}
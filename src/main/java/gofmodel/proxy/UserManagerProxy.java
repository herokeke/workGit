package gofmodel.proxy;

//静态代理
public class UserManagerProxy implements UserManagerService {
    
	//代理对象包含真实对象的引用。
	private UserManagerImpl userManagerImpl;
	
	//通过构造进行setter.
	public UserManagerProxy(UserManagerImpl userManagerImpl){
		this.userManagerImpl = userManagerImpl;
	}
	public String addUser(String pid,String name) {
		checkSession();
		userManagerImpl.addUser(pid,name);
		return null;
	}

	public String delUser() {
		checkSession();
		userManagerImpl.delUser();
		return null;
	}
	
	//添加代理想要执行的逻辑。如，验证用户信息。
	public void checkSession(){
		System.out.println("chek");
	}

}

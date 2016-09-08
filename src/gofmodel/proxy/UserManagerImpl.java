package gofmodel.proxy;

public class UserManagerImpl implements UserManagerService {

	public String addUser(String pid,String name) {
		System.out.println(pid+"addUser"+name);
		return null;
	}

	public String delUser() {
		System.out.println("delUser");
		return null;
	}

}

package gofmodel.proxy;

//��̬����
public class UserManagerProxy implements UserManagerService {
    
	//������������ʵ��������á�
	private UserManagerImpl userManagerImpl;
	
	//ͨ���������setter.
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
	
	//��Ӵ�����Ҫִ�е��߼����磬��֤�û���Ϣ��
	public void checkSession(){
		System.out.println("chek");
	}

}

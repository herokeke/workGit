package gofmodel.proxy;

//抽象接口规范实现
public interface UserManagerService {
	     
	     //添加用户
         public String addUser(String pid,String name);
         
         //删除用户
         public String delUser();
         
}

package gofmodel.proxy;

/**
 * Created by User on 2017/10/16.
 */
public class ProxyTest {

     public static void main(String[] args){
         UserManagerService user = new UserManagerProxy(new UserManagerImpl());
         //  user.addUser();
         // user.delUser();
         SecurityHandler securityHandler = new SecurityHandler();
         user =  (UserManagerService) securityHandler.createProxyInstance(new  UserManagerImpl());
         user.addUser("123","小刚");
         user.delUser();
     }


}

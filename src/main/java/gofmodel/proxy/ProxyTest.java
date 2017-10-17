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
         user.addUser("123","Yhan");
         user.delUser();

         ProxyCglib pc = new ProxyCglib();
         user = (UserManagerService) pc.getInstance(new UserManagerImpl());
         user.addUser("456","cxy");

     }
}

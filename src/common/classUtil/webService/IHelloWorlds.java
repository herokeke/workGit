package common.classUtil.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


@WebService(targetNamespace="http://cxfws.ls.tosp.ceb.com/")
public abstract interface IHelloWorlds {
	// @WebParam给参数命名，提高可代码可读性。此项可选
	@WebMethod
	public abstract String sayHi(@WebParam(name = "text",targetNamespace="http://cxfws.ls.tosp.ceb.com/")
	String text);
}

// 通过注解@WebService申明为webservice接口
// 第二步，实现WebService接口

@WebService
class HelloWorldImpls implements IHelloWorlds {

	public String sayHi(@WebParam(name = "text")
	String text) {
		// TODO Auto-generated method stub
		return "sdsssssssssssss";
	}

}

// 第三步，创建服务端

class Server {

	private Server() {
		IHelloWorlds helloWorld = new HelloWorldImpls();
		// 创建WebService服务工厂
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(IHelloWorlds.class);
		// 发布接口
		factory.setAddress("http://localhost:9000/HelloWorlds");
		factory.setServiceBean(helloWorld);
		// 创建WebService
		factory.create();
	};

	public static void main(String[] args) throws InterruptedException {
		// 启动服务端
		new Server();
		System.out.println("Server ready...");
		// 休眠一分钟，便于测试
		Thread.sleep(10000 * 60);
		System.out.println("Server exit...");
		System.exit(0);
	}
}

// 第四步，创建客户端

class Client {
	public static void main(String[] args) {
		// 创建WebService客户端代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(IHelloWorlds.class);
		// 设置WebService地址
		factory.setAddress("http://localhost:9000/HelloWorlds");
		IHelloWorlds iHelloWorld = (IHelloWorlds) factory.create();
		System.out.println("invoke webservice..."+iHelloWorld.getClass());
		
		System.out.println("message context is:" + iHelloWorld.sayHi("Josen"));
		System.exit(0);
	}
}
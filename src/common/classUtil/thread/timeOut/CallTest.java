package common.classUtil.thread.timeOut;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallTest {
    public static   void main(String [] args)
    {
        ExecutorService service = Executors.newSingleThreadExecutor();//java.util.concurrent包里
        
        Callable<String> callable  = new Callable<String>(){ //实现Callable接口的匿名类
            public String call() throws Exception{
                TimeOutCall toc = new TimeOutCall();
                return toc.CallWithTimeOut(3000);  //3秒返回结果
            }
        };
        Future<String> future = service.submit(callable);
        service.shutdown();
        try {
            if(service.awaitTermination (1000, TimeUnit.MILLISECONDS) == false)//等待1秒后抛出异常。
                throw new TimeoutException();
            System. out.println(future.get());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

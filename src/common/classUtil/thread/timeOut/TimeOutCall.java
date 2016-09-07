package common.classUtil.thread.timeOut;

public class TimeOutCall {
    public String CallWithTimeOut( long timeSetting ) //被测物方法，输入参数可以设置多长时间返回。
   {
           long startTime = System.currentTimeMillis ();
           while(true)
          {
                  if(System.currentTimeMillis() - startTime < timeSetting )
                        continue;
                  else
                        return "Result returned!" ;
          }
   }
}
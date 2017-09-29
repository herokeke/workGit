package common.classUtil.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="http://cxfws.ls.tosp.ceb.com/")
public abstract interface IMessageService
{
  @WebMethod
  public abstract String sendMessage(@WebParam(name="xmlStr", targetNamespace="http://cxfws.ls.tosp.ceb.com/") String paramString);

  @WebMethod
  public abstract String sendTestMessage(@WebParam(name="msg", targetNamespace="http://cxfws.ls.tosp.ceb.com/") String paramString);

  @WebMethod
  public abstract String queryOne(String paramString1, String paramString2);

  @WebMethod
  public abstract String queryList(String paramString1, String paramString2, String paramString3);

  @WebMethod
  public abstract String query(String paramString);

  public abstract String testList();
}
package common.classUtil.webService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.wsdl.Binding;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.xml.namespace.QName;
import javax.xml.rpc.encoding.Deserializer;
import javax.xml.rpc.encoding.DeserializerFactory;
import org.apache.axis.encoding.TypeMapping;
import org.apache.axis.encoding.ser.ElementDeserializerFactory;
import org.apache.axis.encoding.ser.ElementSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializer;
import org.apache.axis.wsdl.gen.Parser;
import org.apache.axis.wsdl.symbolTable.BaseType;
import org.apache.axis.wsdl.symbolTable.BindingEntry;
import org.apache.axis.wsdl.symbolTable.Parameter;
import org.apache.axis.wsdl.symbolTable.Parameters;
import org.apache.axis.wsdl.symbolTable.ServiceEntry;
import org.apache.axis.wsdl.symbolTable.SymTabEntry;
import org.apache.axis.wsdl.symbolTable.SymbolTable;
import org.apache.axis.wsdl.symbolTable.TypeEntry;
import org.apache.axis.wsdl.toJava.Utils;
import org.w3c.dom.Element;

public class DynamicClientFactory
{
  private Parser wsdlParser;
  private Map services = null;

  public DynamicClientFactory(String wsdlURL) throws Exception {
    this.wsdlParser = new Parser();
    this.wsdlParser.run(wsdlURL);
    this.services = enumSymTablEntry(ServiceEntry.class);
  }

  public Object invoke(String serviceName, String portName, String operationName, Vector parameterValues, Integer timeout)
    throws Exception
  {
    Vector inputs = new Vector();

    Vector outNames = new Vector();

    Vector inNames = new Vector();
    Vector inTypes = new Vector();
    String returnName = null;
    ServiceEntry serviceEntry = (ServiceEntry)this.services.get(serviceName);
    javax.wsdl.Service service = serviceEntry.getService();
    org.apache.axis.client.Service clientService = new org.apache.axis.client.Service(
      this.wsdlParser, service.getQName());

    javax.xml.rpc.Call call = clientService.createCall(QName.valueOf(portName), 
      QName.valueOf(operationName));
    ((org.apache.axis.client.Call)call).setTimeout(timeout);
    ((org.apache.axis.client.Call)call).setProperty(
      "DeserializeCurrentElement", Boolean.TRUE);
    BindingEntry bindingEntry = getBindingEntry(serviceName, portName);
    Operation o = getOperation(bindingEntry, operationName);
    Parameters parameters = bindingEntry.getParameters(o);

    int size = parameters.list.size();
    for (int i = 0; i < size; i++) {
      Parameter p = (Parameter)parameters.list.get(i);
      switch (p.getMode()) {
      case 1:
        inNames.add(p.getQName().getLocalPart());
        inTypes.add(p);
        inputs.add(getParamData((org.apache.axis.client.Call)call, p, 
          (String)parameterValues.elementAt(i)));

        break;
      case 2:
        outNames.add(p.getQName().getLocalPart());
        break;
      case 3:
        inNames.add(p.getQName().getLocalPart());
        inTypes.add(p);
        outNames.add(p.getQName().getLocalPart());
        inputs.add(getParamData((org.apache.axis.client.Call)call, p, 
          (String)parameterValues.elementAt(i)));
      }

    }

    if (parameters.returnParam != null) {
      if (!parameters.returnParam.getType().isBaseType()) {
        ((org.apache.axis.client.Call)call).registerTypeMapping(
          Element.class, parameters.returnParam
          .getType().getQName(), 
          new ElementSerializerFactory(), 
          new ElementDeserializerFactory());
      }
      QName returnType = 
        Utils.getXSIType(parameters.returnParam);
      QName returnQName = parameters.returnParam.getQName();
      outNames.add(returnQName.getLocalPart());
      returnName = returnQName.getLocalPart();
    }
    Object ret = call.invoke(inputs.toArray());
    Map outputs = call.getOutputParams();
    Object result = null;

    if (outputs != null) {
      for (int pos = 0; pos < outNames.size(); pos++) {
        String name = (String)outNames.get(pos);
        Object value = outputs.get(name);
        if ((value == null) && (pos == 0))
          result = ret;
        else {
          result = value;
        }
      }
    }
    return result;
  }

  private Object getParamData(org.apache.axis.client.Call c, Parameter p, String arg)
    throws Exception
  {
    QName paramType = Utils.getXSIType(p);

    TypeEntry type = p.getType();
    if (((type instanceof BaseType)) && (((BaseType)type).isBaseType())) {
      DeserializerFactory factory = c.getTypeMapping().getDeserializer(
        paramType);
      Deserializer deserializer = factory
        .getDeserializerAs("Axis SAX Mechanism");
      if ((deserializer instanceof SimpleDeserializer)) {
        return ((SimpleDeserializer)deserializer).makeValue(arg);
      }
    }
    throw new RuntimeException("not know how to convert '" + arg + 
      "' into " + c);
  }

  private Operation getOperation(BindingEntry entry, String operationName) {
    Set operations = entry.getOperations();
    Iterator i = operations.iterator();
    while (i.hasNext()) {
      Operation o = (Operation)i.next();
      if (operationName.equals(o.getName())) {
        return o;
      }
    }
    return null;
  }

  private Map enumSymTablEntry(Class<ServiceEntry> cls) {
    HashMap ret = new HashMap();
    HashMap map = this.wsdlParser.getSymbolTable().getHashMap();
    Iterator iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      QName key = (QName)entry.getKey();
      Vector v = (Vector)entry.getValue();
      int size = v.size();
      for (int i = 0; i < size; i++) {
        SymTabEntry symTabEntry = (SymTabEntry)v.elementAt(i);
        if (cls.isInstance(symTabEntry)) {
          ret.put(key.getLocalPart(), symTabEntry);
        }
      }
    }
    return ret;
  }

  private BindingEntry getBindingEntry(String serviceName, String portName) {
    ServiceEntry serviceEntry = (ServiceEntry)this.services.get(serviceName);
    Port port = serviceEntry.getService().getPort(portName);
    Binding binding = port.getBinding();
    SymbolTable table = this.wsdlParser.getSymbolTable();
    return table.getBindingEntry(binding.getQName());
  }

  public Parameters enumParameters(String serviceName, String portName, String operationName)
  {
    BindingEntry entry = getBindingEntry(serviceName, portName);
    Operation o = getOperation(entry, operationName);
    Parameters parameters = entry.getParameters(o);
    return parameters;
  }
}
package gofmodel.Bridge;

/**
 * 桥接模式
 *      它的主要特点是把抽象（abstraction）与行为实现（implementation）分离开来。
 *   例子：
 *                                      图形
 *                      长方形             |          圆形                  // 类 对象
 *         白色长方形  黑色长方形  黄色长方形   | 白色圆形  黑色圆形  黄色圆形      //颜色为行为
 *         
 *   采用桥连模式后：      
 *               长方形   圆形   白色   黑色    黄色                 // 类 对象
 *    白色长方形  黑色长方形  黄色长方形   白色圆形  黑色圆形  黄色圆形    //颜色为行为
 *         
 *               
 * @author Administrator
 *
 */
public class BridgeTest {

}

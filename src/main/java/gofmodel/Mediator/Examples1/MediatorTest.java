package gofmodel.Mediator.Examples1;

/**
 * 中介者模式
 *        一种 降耦合的 设计。
 *     例子：两个对象  男人Bean  女人Bean 相互的内部都有自己的择偶实现。多个就很复杂了
 *          婚姻中介 中 有 男人和女人的引用 并且 都有统一的实现。
 *      简单讲，将两个耦合性强的类，每个类都有自己的实现及可能重复性的代码多，进行解耦和。
 *             把需要进行解耦和的类放到一起，有多少放多少。相当于群。
 *         实现框架：
 *                  Mediator                                        Colleague{ //持有中介抽象的引用
 *                                                                     Mediator m;
 *                                                                  }
 *                                                                
 *             ConcreteMediator{ 持有目标实现的引用              ConcreteColleagueA   ConcreteColleagueB
 *               ConcreteColleagueA   a;
 *               ConcreteColleagueB   b;
 *               excute(){
 *                 
 *               }
 *             }     
 *             
 *        
 * @author Administrator
 *
 */
public class MediatorTest {

}

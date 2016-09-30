package gofmodel.Builder;

/**
 * 建造者模式  主要是围绕对象的创建过程，大量的创建不同特性的对象，用该模式较好。或者用于权限的不同控制。
 * 
 * 定义接口
 * serviceBuilder{
 *   T属性...
 *   public T getT();
 * }
 * 
 * 实现类
 * ImpBuilder{
 *   T属性...
 *   private T t;
 *   public T getT(){}
 * }
 * 相当于设计师
 * TDirector{
 *  makeT(){
 *  T属性... 可以任意选择需要的属性。可以做简单的权限控制。
 *  }
 * }
 * Bean
 * T{
 *  属性...
 * }
 * 
 */
public class BuilderTest {

}

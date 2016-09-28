package common.classUtil.collectionClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;


public class CollectionTest {
	
	
	/*
	 * 所有的JAVA集合都位于 java.util包中
	 * JAVA集合只能存放引用类型的的数据，不能存放基本数据类型。
	 * 若撰写程序时不知道究竟需要多少对象，需要在空间不足时自动扩增容量，则需要使用容器类库，array不适用。所以就要用到集合。
	 * 
	 * 有人想有可以自动扩展的数组,所以有了List  
     * 有的人想有没有重复的数组,所以有了set  
     * 有人想有自动排序的组数,所以有了TreeSet,TreeList,Tree**  
     * 而几乎有有的集合都是基于数组来实现的.  
     * 因为集合是对数组做的封装,所以,数组永远比任何一个集合要快  
     * 
     * 但任何一个集合,比数组提供的功能要多  
     * 一：数组声明了它容纳的元素的类型，而集合不声明。这是由于集合以object形式来存储它们的元素。  
     * 二：一个数组实例具有固定的大小，不能伸缩。集合则可根据需要动态改变大小。  
     * 三：数组是一种可读/可写数据结构，没有办法创建一个只读数组。然而可以使用集合提供的ReadOnly方法，以只读方式来使用集合。该方法将返回一个集合的只读版本。
	 */
	
	
	
	
	/*
	 * List: 的特征是其元素以线性方式存储，集合中可以存放重复对象。
	 *       次序是List最重要的特点,它保证维护元素特定的顺序。
	 *       List为Collection添加了许多方法，使得能够向List中间插入与移除元素(这只推 荐LinkedList使用。)一个List可以生成ListIterator,使用它可以从两个方向遍历List,也可以从List中间插入和移除元 素。 
	 * ArrayList() : 由数组实现的List,代表长度可以改变得数组。可以对元素进行随机的访问，向ArrayList()中插入与删除元素的速度慢。 
	 *               允许对元素进行快速随机访问，但是向List中间插入与移除元素的速度很慢。ListIterator只应该用来由后向前遍历 ArrayList,而不是用来插入和移除元素。因为那比LinkedList开销要大很多。 
     * LinkedList(): 在实现中采用链表数据结构。插入和删除速度快，访问速度慢。 
     *               对顺序访问进行了优化，向List中间插入与删除的开销并不大。随机访问则相对较慢。(使用ArrayList代替。)还具有下列方 法：
     *               addFirst(), addLast(), getFirst(), getLast(), removeFirst() 和 removeLast(), 
     *               这些方法 (没有在任何接口或基类中定义过)使得LinkedList可以当作堆栈、队列和双向队列使用。
     *               
     * Vector：
     * 
	 */
	
	@Test
	public void testList(){
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		
		System.out.println(list.size());
		for(ListIterator<String> it =  (ListIterator<String>) list.listIterator();it.hasNext();){
			   System.out.println(it.next());
		}
		for(String str: list ){
			System.out.println(str);
		}
	}
	
	/*
	 * Set是最简单的一种集合。集合中的对象不按特定的方式排序，并且没有重复对象。
	 *   Set具有与Collection完全一样的接口，因此没有任何额外的功能，不像前面有两个不同的List。实际上Set就是Collection,只是行为不同。
	 *   (这是继承与多态思想的典型应用：表现不同的行为。)Set不保存重复的元素(至于如何判断元素相同则较为负责) 
     *   存入Set的每个元素都必须是唯一的，因为Set不保存重复元素。加入Set的元素必须定义equals()方法以确保对象的唯一性。
     *   Set与Collection有完全一样的接口。Set接口不保证维护元素的次序。
	 * 
	 * HashSet： HashSet类按照哈希算法来存取集合中的对象，存取速度比较快 
	 *          是为快速查找设计的Set，存入HashSet的对象必须定义hashCode()。
     * TreeSet ：TreeSet类实现了SortedSet接口，能够对集合中的对象进行排序。 
	 *          保存次序的Set, 底层为树结构。使用它可以从Set中提取有序的序列。
	 *          
	 * LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序(插入的次序)。于是在使用迭代器遍历Set时，结果会按元素插入的次序显示。
	 * 
	 * 
	 */
	
	@Test
	public void testSet(){
		Set set = new HashSet();
	}
	
	
	/*
	 * Map 是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。 
	 *      Map没有继承于Collection接口 从Map集合中检索元素时，只要给出键对象，就会返回对应的值对象。 
	 *      获得与关键字key相关的值 ，Map集合中的键对象不允许重复，也就说，任意两个键对象通过equals()方法比较的结果都是false.，但是可以将任意多个键独享映射到同一个值对象上。 
	 *      
	 *      
	 * HashMap就是使用对象的hashCode()进行快速查询的。此方法能够显着提高性能。 
	 * 
	 * 
	 * 
	 * 1. 装载因子？扩容。
	 */
	@Test
	public void testMap(){
		
		Map map = new  HashMap();
		
	}
	
}

package common.classUtil.collectionClass;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;


public class ArraysTest {

	/*
	 * 数组是大小固定的，并且同一个数组只能存放类型一样的数据（基本类型/引用类型）
	 * Java所有“存储及随机访问一连串对象”的做法，array是最有效率的一种。
	 * 效率高，但容量固定且无法动态改变。
     * array还有一个缺点是，无法判断其中实际存有多少元素，length只是告诉我们array的容量。
	 */
	@Test
	public void testArray(){
		String[] str  = new String[5];
		assertEquals(5,str.length); 
		
		String[][] strs = new String[][]{{"a","b","c"},{"甲","乙"}};
		for(int i=0;i<strs.length;i++){
			 // strs[i] 获取一位数组数据
			for(String sr:strs[i]){
				System.out.println(sr); //获取每一个元素
			}
		}
	}
	
	@Test
	public void testArrays(){
		String[] str = new String[]{"甲","乙","丙"};
	
		
		int[] iarray  = new int[]{21,13,24,2,6,30,9,10,25,48,57};
		printValue(iarray);
		Arrays.sort(iarray);  // 排序
		System.out.println();
		printValue(iarray);
		/*
		 * 必须根据元素的自然顺序对数组进行升序排序（通过 sort(Object[]) 方法）。如果没有对数组进行排序，则结果是不确定的
		 *  binarySearch(T[],value) 返回索引
		 */
		int index = Arrays.binarySearch(iarray,2); 
		System.out.println("\r\n"+ index);
		
		Arrays.fill(iarray, 100); //赋值
		
		printValue(iarray);
		int[] destArray  = new int[3];
		//复制 数组
		//System.arraycopy(原数组, 原数组开始位置, 目标数组, 目标数组开始位置, 原数组长度)
				
		System.arraycopy(iarray, 0, destArray, 0, 3);
		System.out.println();
		printValue(destArray);
		//果两个数组相等，则返回 true
		System.out.println(Arrays.equals(iarray, destArray));
	}
	
	public void printValue(final int[]  obj){
		for(Object i: obj){
			System.out.print(i);
		}
	}
}

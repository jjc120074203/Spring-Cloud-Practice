package com.javabase.javaEight.lambdaAndStream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * java8 提供了Stream 接口，说白了是对Collection接口的增强操作，他的出现提高了对对象集合高效聚合
 * 他的特点：并行处理 ，直接实现你需要什么
 * 
 * Stream 单项迭代器 数据只能遍历一遍
 * Stream 可以并行化操作,使用并行去遍历时，数据会被分成多个段，其中每一个都在不同的线程中处理，然后将结果一起输出
 * @author issuser
 *
 */
public class StreamTest {

	//Stream 声明转换
	@Test
	public void test(){
		String [] strArray = new String[] {"a", "b", "c"};
		//转换对象
		Stream st=Stream.of(strArray);
		Stream st1=Arrays.stream(strArray);
		
		//1.forEach 循环遍历流中的元素
//		st1.forEach(x->System.out.println(x));
//		st1.forEach(System.out::println);
		
		//2.map 方法用于映射每个元素到对应的结果
		List<Integer> list1=Arrays.asList(2,1,3,4,1,1,9,12);
		//通过 stream()现将集合转换成流  map 将集合进行转换
		List<Integer> list1res= list1.stream().map(i->mapMethod(i)).collect(Collectors.toList());
		list1res.stream().distinct().forEach(System.out::println);
		
		//3.filter 对集合对象进行过滤
		List<Integer> list2=Arrays.asList(2,1,3,4,1,1,9,12);
		List<Integer> list2res=list2.stream().filter(temp->filterMethod(temp)).collect(Collectors.toList());
		list2res.stream().forEach(System.out::println);
		
		//4.sorted 对集合进行排序
		list1res.stream().sorted().forEach(System.out::println);
		
		//
		//3.reduce 将前一个对象的集合 结果放入下一个集合
		List<Integer> list4=Arrays.asList(1,2,3,4,5);
		Integer list4s=list4.stream().reduce(100,Integer::sum);
		System.out.println("总和"+list4s);
		
		
		//2.map 方法用于映射每个元素到对应的结果
		List<Ditial> list5=new ArrayList<>();
		Ditial a=new Ditial(1);
		Ditial a1=new Ditial(2);
		Ditial a2=new Ditial(3);
		Ditial a3=new Ditial(4);
		Ditial a5=new Ditial(5);
		Ditial a4=new Ditial(6);
		list5.add(a1);
		list5.add(a2);
		list5.add(a3);
		list5.add(a4);
		list5.add(a5);
		//通过 stream()现将集合转换成流  map 将集合进行转换
		for (Ditial ditial : list5) {
			System.out.println(ditial.getA());
		}
		
		List<Ditial> list5res= list5.stream().map(i->mapMethod1(i)).collect(Collectors.toList());
		for (Ditial ditial : list5res) {
			System.out.println(ditial.getA());
		}
	}
	//filter的过滤方法 返回值必须 boolean 类型
	public static Integer  mapMethod(Integer a){
			return a * a;
	}
	
	//filter的过滤方法 返回值必须 boolean 类型
		public static Ditial  mapMethod1(Ditial a){
			a.setA(a.getA()+1);
				return a;
		}
	
	//filter的过滤方法 返回值必须 boolean 类型
	public static boolean filterMethod(Integer a){
		if (a==1) {
			return false;
		}
		return true;
	}
}

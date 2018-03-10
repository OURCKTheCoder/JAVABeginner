package basicMethod;

import java.util.*;

public class ParameterPassing {
	
	public int ClassMember;
	
	/* - OURCK : JAVA中函数的参数传递
	 * 
	 * 与C++不一样，JAVA不提供指针机制。
	 * 因此，先手结论：
	 * 
	 * 		[!] 在JAVA中函数参数的传递只有值传递一种方式。 [!]
	 * 
	 * 这个问题要从JAVA中的“值”和“引用”讲起。
	 * 
	 * Java中数据类型分为两大类，基本类型和对象类型。相应的，变量也有两种类型：基本类型和引用类型。
	 * 
	 * 基本类型的变量保存原始值，即它代表的值就是数值本身；
	 * 		▢ ▢ ▢ ▣ ▢
	 *              A
	 * “基本类型”包括：byte,short,int,long,char,float,double,Boolean,returnAddress，
	 * 
	 * 而引用类型的变量保存引用值，"引用值"指向内存空间的地址，代表了某个对象的引用，而不是对象本身。
	 * 		▢ ▢ ▢ ▣ ▢
	 * 		        ↑			‘当然，别把这里的箭头当成指针。
	 * 		        A
	 * “引用类型”包括：类类型，接口类型和数组。
	 */
	
	/*
	 * 基本数据类型在声明时系统就为他分配内存空间。
	 * 而引用类型声明时，只为变量分配了“引用空间”（足以存放引用地址的空间），而不分配数据空间。
	 * 
	 * 当然"引用"也是占用空间的，一个空Object对象的引用大小大概是4byte。
	 * 4byte用于存放20位物理内存地址：段地址和偏移地址，各十六位（XXXX:XXXX)
	 * 但：
	 * Java中通过toString()获得的不是直接的物理地址，
	 * 而是一串”根据零散的堆内存地址，通过哈希算法转换来的数字字符“，用来表征对象的”地址“。
	 * （因为new内存空间的开辟往往不是连续的）
	 */
	
	public void test() {
		int a;
		a=0; //没毛病，a有他自己的空间，能用于存放数据。
		
		Date t; //开辟足以存放一个Date对象的数据空间，并将 #该空间的首地址# 返回给变量t
		//System.out.println(t.getDate()); //没有分配数据空间 = “没有初始化”？
		t = new Date();//这一步才对其数据空间进行分配。
		System.out.println(t.getTime());
		System.out.println();
		
		/* [+] 实例：值传递 和 引用传递
		 * 
		 * 以下代码将帮助体现出值传递和引用传递的区别。
		 * 注意观察输出中 分别代表 处理前->处理中（函数调用中）->处理后 三个阶段的值。
		 */
		
		ParameterPassing OBJ1 = new ParameterPassing();//引用类型变量 OBJ1
		int OBJ2;//基本类型变量 OBJ2
		
		OBJ1.ClassMember = 99;
		OBJ2 = 99;		
		
		System.out.println("Original OBJ1.ClassMember = " + OBJ1.ClassMember + " ; Original OBJ1 = " + OBJ1);
		System.out.println("Original OBJ2 = " + OBJ2);
		
		System.out.println("OBJ1 OnProceeding = " + OnCallFun(OBJ1));
		System.out.println("OBJ2 OnProceeding = " + OnCallFun(OBJ2));
		
		System.out.println("Final OBJ1.ClassMember = " + OBJ1.ClassMember + " ; Final OBJ1 = " + OBJ1);
		System.out.println("Final OBJ2 = " + OBJ2);
		System.out.println();
		
		/*
		 * 可以看到，函数内部对形参的操作
		 * 对于 按值传递 的 基本类型变量 OBJ1而言，这个操作与他没关系，因为形参与实参是两回事；
		 * 对于 引用传递 的 引用类型变量 OBJ2而言，这个操作直接发生在OBJ2身上，因为形参就是实参本身。
		 * 
		 * 更进一步地，应该说
		 * 
		 * 		“所谓的引用传递实际上只是内存地址的值传递”。
		 * 
		 * 因此可以猜测：类似指针一样，通过将某一变量的所在地址按值传递
		 * 可以达到在函数体内部直接通过形参处理实参本身的效果。
		 */
		
		/* [!] 装箱也不能引用传递 [!]
		 * 
		 * 有好事者言：能否通过装箱来对 基本类型变量 实现引用传递的处理方式呢：
		 * 不妨一试：
		 */
		
		Integer OBJ3 = 99;

		System.out.println("Original OBJ3 = " + OBJ3);	
		System.out.println("OBJ3 OnProceeding = " + OnCallFun(OBJ3));	
		System.out.println("Final OBJ3 = " + OBJ3);
		
		/*
		 * 结果上看，是不能的。同样是“类型（Class）"，装箱类却不能引用传递。
		 * 这似乎和之前说好的不一样啊？？
		 * 
		 * 实际上，仔细看看，这回这个OBJ3对象输出时不再是一个地址了，
		 * 而是直接的一个整型数值。在传递时把这个值拷贝给形参时，就注定了函数不再能通过形参操作实参了。
		 * 也就是，“形参和实参脱离了关系”。
		 * 
		 * 		[!] 这再次印证了 引用传递的本质就是按值传递 的道理。 [!]
		 * 
		 * 再往深究，这个东西在网上也是说不清楚。有几种说法，どちらでしょか？
		 * 
		 * 1.是因为那些包装类（比如：Integer）是被immutable修饰的。
		 *   “因为没有提供自身修改的函数，每次操作都是新生成一个对象，所以要特殊对待，可以认为是和基本数据类型相似，传值操作。”
		 * 
		 * 2.缺少对应属性值的setter方法。
		 * 
		 * 3.Integer中有一个属性value，他保存了当前变量的值。
		 *   这个值在官方的文档中被注明为：
		 *   		peivate final int value
		 *   （异义！要真这样，为什么能为Integer对象重新赋值？）
		 *   （
		 *   	对于一个终态对象，程序里显式的对其进行修改一定会报错，因此对于“为什么能为Integer对象重新赋值”这一问题，想到的可能有二：
		 *   		· 内部对这种异常做了处理；
		 *   		· “=”也像String类对象那样 仅仅是修改了引用而已。
		 *   ）
		 *   
		 *   以上问题，期待权威专业的解释。
		 */

	}
	
	/* - OURCK : 方法的重载
	 * 
	 * 跟C++差不多，JAVA也支持对方法的重载机制。
	 * 以参数类型 / 参数个数 / 返回类型 来区分 应该选择哪一个重载函数
	 */
	
	private int OnCallFun(ParameterPassing OBJ) {
		OBJ.ClassMember = ++OBJ.ClassMember;
		return OBJ.ClassMember;
	}
	
	private int OnCallFun(int val) {
		val = ++val;//看看编译器说了什么？
		return val;
	}
	
	private Integer OnCallFun(Integer val) {
		val++;
		return val;
	}

}

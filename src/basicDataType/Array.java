package basicDataType;

public class Array {
	/* - OUECK ：数组的声明
	 * 
	 * 在JAVA里面，数组的声明大概有两种格式，其初始化方式也可以直接赋值或者是new出来：
	 */
	
	private static final int a[] = {1,2,3};//Allow an empty index when initializing. A C/C++-style statement works!
	
	private static final int[] c = {1,2,3,4,5,6,7,8,9};
	private static final int[] b = new int[3];//A JAVA-style statement. or "int b[]"...but when we "new" it, the default value is 0.
	
	/*
	 * 建议使用 dataType[] arrayRefVar 的声明风格声明数组变量。 
	 * dataType arrayRefVar[] 风格是来自 C/C++ 语言 ，
	 * 在Java中采用是为了让 C/C++ 程序员能够快速理解java语言。
	 */
	
	public void test() {
		System.out.println(a);//数组名代表首地址吗？
		System.out.println(a[1]);
		System.out.println(b[1]);
		
		 /* 
		  * 与C++不一样（或者说C++与其他语言不一样），JAVA对数组越界做检查。
		  * 数组越界将引发运行时错误（而不是编译时）
		  */
		
		//System.out.print(b[4]);//Illegal index will be checked.
		
		System.out.print(b.length);
		
		/* - 针对数组的特殊增强型循环
		 * 
		 * 类似.NET，JDK1.5引入了 foreach 增强型循环
		 * 		for ([type] [OBJ] : [Array]) {...}
		 * 它类似于VB.NET中的：
		 * 		for each [OBJ] As [type] In [Group] ... Next
		 * 
		 * 下面这段代码实现对数组内所有元素的求和：
		 */
		
		int s = 0;
		for (int element : a) {
			s += element;
		}
		System.out.println(s);
		
		/* - 数组作函数参数 & 函数返回
		 * 
		 * 1.作函数参数 一般语法：
		 * [type] [Function_NAME] ( [type][] [Array_NAME] )
		 * 比如：
		 * public static void main( String[] args)
		 * 
		 * 2.作函数返回
		 * [type][] [Function_NAME] ( ... ) { ... return [Array_NAME] }
		 */
		
		/* - 多维数组
		 * 
		 * 类似C++。例如：
		 * 		String str[][] = new String[3][4];
		 * 需要说明的是，不同于C++，
		 * 二维数组的第二维不需要在编译前确定。
		 * 		String s[][] = new String[2][]; 
		 */
		
		/* - 数组倒序的测试 */
		System.out.println("Σ( ° △ °  ) 数组倒序测试~~");
		for (int i : c) { System.out.print(i); }
		System.out.println();
		
		int[] temp1 = reverseAry(c);
		for (int i : temp1) { System.out.print(i); }
		System.out.println();
		
		/* - 选择排序的测试 */
		System.out.println("Σ( ° △ °  ) 选择排序测试~~大的在前面哟~~");
		for (int i : c) { System.out.print(i); }
		System.out.println();
		
		int[] temp2 = selectSeq(c);
		for (int i : temp2) { System.out.print(i); }
		System.out.println();
	}
	
	/* [+] 实例：数组倒序
	 * 
	 * 以下代码实现一个数组的逆序存放。
	 */
	public int[] reverseAry(int[] ary) {
		int[] rst = new int[ary.length];
		for(int i=0; i < ary.length; i++) {
			rst[ary.length - 1 - i] = ary[i];
		}
		return rst;
	}
	
	/* [+] 实例：选择排序
	 * 
	 * 以下代码实现一个数组的选择排序。大在前。
	 */
	public int[] selectSeq(int[] ary) {
		
		for(int i = 0; i < ary.length - 1; i++) {
			int k = i;//Reset ptr pointing to current num.
			for(int j = i; j < ary.length; j++) {
				if(ary[j] > ary[i]) {
					k = j;
				}
				if(k != i) {
					int temp = ary[i];
					ary[i] = ary[k];
					ary[k] = temp;
				}
			}
		}
		
		return ary;
	}
}

package basicDataType;

public class Chars {
	/* - OURCK : 与字符（串）有关的数据类型和结构
	 * 
	 * JAVA中主要的有char（Character）、String、StringBuffer & StringBuilder。
	 */
	
	char c0 = 'A';
	Character c1 = new Character('B');
	String str1 = "ABCDEFG";
	
	/* - 先说结论：
	 * 
	 * String 长度大小不可变
	 * StringBuffer 和 StringBuilder 长度可变
	 * StringBuffer 线程安全 StringBuilder 线程不安全
	 * StringBuilder 速度快
	 */
	
	
	/* - 详细介绍：
	 * 
	 * 与C++类似，String不是内置数据类型
	 * 而是一个具有很多有用的方法的类。
	 * 比如String.length()返回该对象的长度。
	 * String.concat()连接两个字符串，并返回该新字符串。
	 */
	
	public void test() {
		
		System.out.println(c0);
		System.out.println(c1);
		System.out.println(str1 + str1.length());
		
		String str2 = "JJKKLHG";
		System.out.println(str1.concat(str2));
		
		/* ▲ String变量不能修改 ▲
		 * 
		 * 不过有个很要命的问题
		 * String 是被 final修饰的，他的长度是不可变的。
		 * 因此String类型变量一经初始化，就不能再改变它的值。
		 * 比如：
		 */
		
		System.out.println(str2);
		str2 = "LOOLOLOL~~~";
		System.out.println(str2);
		
		/*
		 * 看似，两次输出值不一样，str2已经“成功被修改”；
		 * 那也只是看似。
		 * 实际上，语句：
		 * 		String [OBJ] = [Str_Const]
		 * [OBJ]仅仅是 #对象# [Str_Const]的一个引用。
		 * 第二次的“=”运算符实际上是把原来的引用修改了罢了。
		 * 原来的String #对象# ，就是”JJKKLHG“，仍然存在于内存中。
		 * 过一会应该会被GC回收。
		 * http://www.runoob.com/java/java-string.html
		 */
		
		/*
		 * 顺便，从上面的例子中可以看出
		 * JAVA中的引用不同于C++
		 * 是可以二次修改的！？
		 */
		
		/*
		 * 在JAVA中，如若有修改的需求，
		 * 则应使用StringBuffer类。
		 */
		
		StringBuffer str3 = new StringBuffer("Test StringBuffer");
		//StringBuilder str3 = new StringBuilder("Test StringBuilder");
		
		/*
		 * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，
		 * 并且不产生新的未使用对象。
		 * 
		 * ——“StringBuilder 类在 Java 5 中被提出，
		 * 它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。”
		 * 
		 * 这俩货有一些很常用的方法：
		 * 1.append(String str) 用于连接字符串。参数可以是很多类型。
		 * 2.replace(int start, int end, String str) 使用给定 String 中的字符替换此序列的子字符串中的字符。
		 * ... http://www.runoob.com/java/java-stringbuffer.html
		 */
		
		System.out.println(str3);
		str3.append("LOLOLOLLLLLLLLLL~~~~~");
		System.out.println(str3);
		
		System.out.println(str3.replace(0, str2.length(), str2));
	}
}

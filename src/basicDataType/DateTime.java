package basicDataType;

import java.util.Date;

public class DateTime {

	/* - OURCK : Date类
	 * “java.util 包提供了 Date 类来封装当前的日期和时间。
	 *  Date 类提供一些构造函数来实例化 Date 对象。
	 *  
	 *  第一个构造函数使用 #当前日期和时间# 来初始化对象。
	 */
	
	Date t1 = new Date();
	
	/*
	 * 第二个构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数。 
	 * ...似乎很多程序都从1970年开始计时啊？
	 */
	
	Date t2 = new Date(10000);
	
	/*
	 * 除此之外，还有一些更现代化的方法用于构造。
	 * 他们往往有一些更现代化的参数。
	 */
			
	public void test() {
		/* - Date类的一些方法
		 * 一般的大于号、小于号当然并没有重载用于比较两个Date对象的大小。
		 * 因此，Date有方法：
		 * 
		 * 		after() 和 before() 以及 equalTo()
		 * 
		 * 返回值为布尔型。
		 * 
		 * 除此之外，也可以使用继承下来的 compareTo()。
		 */
		
		System.out.println(t1.after(t2));
		
		/* 
		 * 获取系统当前时间
		 * 		getTime()
		 * 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
		 */
		
		System.out.println(t1.getTime());
		
		/*
		 * 估计不太常用，知道一点就行了。
		 */

	}
}

package basicMethod;

public class Constructor {
	
	/* - OURCK : 构造方法 和 finalize()
	 * 
	 * 类似C++，上面俩货
	 * 一个对应构造函数，一个对应析构函数。
	 * 
	 * 跟C++不一样的是，这里的构造方法和finalize()方法更一般化了。
	 * 这意味着，编写这两个方法时，需要更多的考虑到它们的可访问性等等一般方法有可能遇到的问题。
	 */
	
	
	/*Part I. 构造方法
	 * 
	 * 当一个对象被创建时候，构造方法用来初始化该对象。构造方法和它所在类的名字相同，但构造方法没有返回值。 
	 * 通常会使用构造方法给一个类的实例变量赋初值，或者执行其它必要的步骤来创建一个完整的对象。 
	 * 不管你与否自定义构造方法，所有的类都有构造方法，因为Java自动提供了一个默认构造方法，它把所有成员初始化为0。 
	 * 一旦你定义了自己的构造方法，默认构造方法就会失效。 
	 */
	public Constructor(){
		System.out.println("Constructor is constructing...");
	}
	
	/*Part II. finalize()方法
	 * 
	 * Java允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。 
	 * 
	 * 		[!] 注意：该方法 “在析构之前” 被调用，即 ：finalize()方法跟析构是两码事。（关于这一点，看书签：“finalize() 不是 ’析构‘”）[!]
	 * 
	 * JAVA中的 GC [1] 只负责内存相关的清理，所有其它资源的清理必须由程序员手工完成。
	 * 例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。 
	 * 
	 * ___________________
	 * [1] GC,GarbageCollection,垃圾回收机制。
	 *     在Java中开发人员无法使用指针来自由的管理内存，GC是JVM对内存（实际上就是对象）进行管理的方式。
	 *     GC使得Java开发人员摆脱了繁琐的内存管理工作，让程序的开发更有效率。
	 */
	protected void finalize() {
		System.out.println("\"Destructor\" is destructing...");
	}
	/*
	 * 关键字 protected 是一个限定符，它确保 finalize() 方法不会被该类以外的代码调用。 
	 * 一般情况下，Java 的内存回收可以由 JVM 来自动完成。
	 * 
	 * “如果需要手动使析构对象，则可以使用上面的方法。 ”
	 * 这句话有两层意思：
	 * 
	 * 1.字面意思，在“需要的时候”可以手动地析构对象，通过手动地调用finalize()方法。
	 *   什么是“需要的时候”？JVM的垃圾回收器不能处理的特殊情况发生时。http://blog.csdn.net/u013366812/article/details/52046678
	 *   
	 * 2.finalize()并不是在过程结束时自动调用的。因为没有调用的必要：
	 * 
	 * 		JVM的垃圾回收机制通常不依赖于一个对象的finalize()方法；
	 * 		finalize()方法不等于"析构函数"；
	 * 		正常的析构是通过调用System.gc()来完成的。
	 * 
	 *   “可以说正是由于存在JVM垃圾回收机制，所以Java没有析构函数。”
	 *   用户可以自己调用对象的finalize方法，但是这种调用是正常的方法调用，和对象的销毁过程无关。
	 */
	
	public void test() {
		Constructor constructor = new Constructor();
	}
}

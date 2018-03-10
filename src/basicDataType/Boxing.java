package basicDataType;

public class Boxing {
	
	public void test() {
		/* - OURCK : “装箱”
		 * 
		 * 基本数据类型,例如 int、float、double、boolean、char 等,是不具备对象的特性的，
		 * 比如基本类型不能调用方法、功能简单，等等，
		 * 为了让基本数据类型也具备对象的特性， Java 为每个基本数据类型都提供了一个包装类，
		 * 这样我们就可以像操作对象那样来操作基本数据类型。 
		 * 
		 * 在上面，Integer是int的“包装类”，而Integer是Number的一个子类（Number类在java.lang包中声明和定义）
		 * 以这种方式声明变量，相较于int声明，这种声明方式称为“装箱”
		 * 这样一来，对象"i0"也可以调用一些方法了。比如：
		 */
		int i1 = 3;
		Integer i0 = 3;
		
		System.out.println(i0.hashCode());
		
		/*
		 * 然而，旁边那个int出来的妖艳贱货就不行。
		 * 不信你试试：
		 */
		
		//System.out.println(i1.hashCode());
		
		/*
		 * 除此外，Integer对象和int对象在使用上应该就没多少差别了：
		 */
		
		System.out.println(i0 + " " + i1);
		
		/*
		 * 不过在上面的那行代码中，编译器对Integer对象i0进行了“拆箱”
		 * 因为要“让对象支持加法运算”。
		 * 初步猜测是因为“+"运算符没有合适的重载去处理Integer对象？
		 */
		
		/*
		 * 除去表示数字的Number，char也有对应的包装类，Character.
		 */
		
		Character char1 = new Character('A');
		System.out.println(char1.charValue());
	}
	
}


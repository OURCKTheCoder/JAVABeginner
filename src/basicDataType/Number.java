package basicDataType;

public class Number {
	public static final double PI=3.1415926;
	
	public void test() {
		int i1=0, i2=1;

		while(i1<8) {
			double x1 = Math.cos(PI/2 * i1);
			System.out.println(x1);
			i1++;
		}
		
		System.out.println("--------------------------");
		
		do {
			double x2 = Math.log(i2);
			System.out.println(x2);
			i2++;
		}while(i2<4);

		System.out.println("--------------------------");
		
		for(int i3=0; i3<=10; i3++) {
			double x3  = Math.log10(i3);//JAVA supports "-Infinity"!
			if(x3 == 1) System.out.println("Log10(10)!");
			else System.out.println(x3);
		}
		
		System.out.println("--------------------------");
		
		int a[]= {1,2,3,4,5,6,7,8,9};
		for(int val : a) {
			System.out.print(val + ", ");
		}
	}
}

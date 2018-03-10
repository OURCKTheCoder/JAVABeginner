package _mainConsole;

import basicDataType.*;
import basicMethod.*;

public class RoadShow {
	
	public static void main(String[] args) {
			Boxing i_InBoxSample = new Boxing();
			Array i_ArraySample = new Array();
			basicDataType.Number i_MathSample = new basicDataType.Number();
			Chars i_CharsSample = new Chars();
			ParameterPassing i_PPSmple = new ParameterPassing();
			Constructor i_CstSample = new Constructor();
			
			/*
			 * 起名字起得不好：自己起的Number跟系统内置的重名了。。。
			 * 这里通过显示引入包的名字来限定
			 */
			
			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -I");
			System.out.println("---------------------------------------");
			i_InBoxSample.test();
			System.out.println();
			
			
			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -II");
			System.out.println("---------------------------------------");
			i_ArraySample.test();
			System.out.println();			


			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -III");
			System.out.println("---------------------------------------");
			i_MathSample.test();
			System.out.println();
			
			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -IV");
			System.out.println("---------------------------------------");
			i_CharsSample.test();
			System.out.println();
			
			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -V");
			System.out.println("---------------------------------------");
			i_PPSmple.test();
			System.out.println();
			
			System.out.println("---------------------------------------");
			System.out.println("			P     A     R     T    -V");
			System.out.println("---------------------------------------");
			i_CstSample.test();
			System.out.println();
			
		}
	
}

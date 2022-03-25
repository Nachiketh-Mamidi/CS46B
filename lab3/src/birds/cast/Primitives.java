package cast;

public class Primitives {
	
	public static void dumpMaxValues() {
		System.out.println("Max Byte" + Byte.MAX_VALUE);
		System.out.println("Max Short" + Short.MAX_VALUE);
		System.out.println("Max Integer" + Integer.MAX_VALUE);
		System.out.println("Max Long" + Long.MAX_VALUE);
		System.out.println("Max Float" + Float.MAX_VALUE);
		System.out.println("Max double" + Double.MAX_VALUE);
	}

	public static void main (String[] args) {
		dumpMaxValues();
		
		//int to long
		long l = Long.MAX_VALUE;
		int i = (int)l;
		System.out.println("int to long: "+ i+ ", "+ l);
		
		//int to long
		long l1 = Long.MAX_VALUE - 5 ;
		int i1 = (int) l1;
		System.out.println("int to long: "+ i1 + ", "+ l1);
		
		//long to int
		int i2 = Integer.MAX_VALUE;
		long l2 = i2;
		System.out.println("long to int: "+ l2+ ", "+ i);
		
		//double to byte more numbers
		byte b = 100;
		double d = b;
		System.out.println("double to byt: "+ d+ ", "+ b);
		
		//byte to double, 
		double d1 = 45.67;
		byte b1 = (byte)d1;
		System.out.println("byte to double: "+ b1 + ", "+ d1);
		
		//byte to double, approx the same
		double d2 = 456.789;
		byte b2 = (byte)d2;
		System.out.println("byte to double: "+ b2 + ", "+ d2);
		
		//long to float
		long l9 = (long)12345.6789f;
		float f9 = l9;
		System.out.println("long to float: "+ l9+ ", "+ f9);

		//float to loang
		float f = 12345.6789f;
		long l3 = (long)f;
		System.out.println("float to long: "+ l3+ ", "+ f);
		
		//float to long MAX
		long l4 = Long.MAX_VALUE;
		float f1 = l4;
		System.out.println("float to long MAX: "+ f1+ ", "+ l4);
				
				
				
	}
}

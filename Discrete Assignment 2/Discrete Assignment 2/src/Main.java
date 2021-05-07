import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long a,b,m;
		long a1,b1,m1;
		long c=1;
		long start;
		long end;
		long time;
		while(true) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the three integers A,B,M to find A^B % M");
		a = input.nextLong();
		b = input.nextLong();
		m = input.nextLong();
		//saving the inputs in other variables to avoid losing them whne calculating on them
		a1=a;
		b1=b;
		m1=m;
		//max byte 127 8 bits
		//max short 32767 16 bits
		//max long 2147483647 32 bits
		//max long 9223372036854775807 64 bits
		
		//method 1  , overflow when a^b > max value
		c=1;
		//check for overflow
		if(Math.pow(a,b)>Long.MAX_VALUE) System.out.println("OVERFLOW");
		start = System.nanoTime();
		for (long i=0;i<b;i++) {
			c=c*a;
		}
		c=c%m;
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Method 1 result: "+ c +"\nElapsed time: "+time + " ns\n\n");
		//end of method 1
		
		//method 2 overflow could happen if a*m> max  
		//making sure we have the right values
		c=1;
		a=a1;
		b=b1;
		m=m1;
		//check for overflow
		try {
			Math.multiplyExact(a, m);
		}
		catch (Exception e) {
			System.out.println("Overflow is possible");
		}
		start = System.nanoTime();
		
		for (long i=0;i<b;i++) {
			c=c*a%m;
		}
		
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Method 2 result: "+ c + "\nElapsed time: "+time + " ns\n\n");
		
		//end of method 2

		//method 3 iterative 
		//making sure we have the right values
		c=1;
		a=a1;
		b=b1;
		m=m1;
		start = System.nanoTime();
		
		a=a%m;
		while(b>0) {
			//tests the least significant bit
			if((b & 1)==1)
				c=(c*a)%m;
			a=a*a%m;
			//moves on the the next bit on the left
			b=b>>1;
		}
		
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Method 3 result: "+ c + "\nElapsed time: "+time + " ns\n\n");
		//end of method 3
		
		//method 4 
		//making sure we have the right values
		c=1;
		a=a1;
		b=b1;
		m=m1;
		start = System.nanoTime();
		c=rec(a,b,m);
		end = System.nanoTime();
		time = (end-start);
		System.out.println("Method 4 result: "+ c + "\nElapsed time: "+time + " ns" +"\n\n");
		//end of method 4
		

		}
	}
	//the recursive function
	static long rec (long a,long b,long m) {
		if(b==0)
			return 1;
		long c = rec(a,b>>1,m);
		c=(c*c)%m;
		//tests the least significant bit
		if ((b&1)==0)
			return c;
		else
			return c*(a%m)%m;
		
	}
}

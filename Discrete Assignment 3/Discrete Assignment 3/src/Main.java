import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		while(true) {
		Scanner input = new Scanner(System.in);
		String choice = "a";
		do {
			System.out.println("Enter the letter corresponding to your choice");
			System.out.println("A: Sieve of Eratosthenes algorithm\nB: Trial Division algorithm\nC: Extended Euclidean algorithm\nD: Chinese remainder theorem\nE:  Miller’s test\n");
			choice = input.nextLine();
		} 
		while (choice.length()!= 1);
		choice = choice.toLowerCase();
		char c = choice.charAt(0);
		switch (c) {
		case 'a':
			System.out.println("Enter the limit: ");
			int n = input.nextInt();
			boolean[] primes = SieveOfEratosthenes.sieveOfEratosthenes(n);
		    System.out.println("all prime numbers up to "+n +" : ");
		    for (int i = 2; i<= n; i++) {
		    	if(primes[i]==true) {
		    		System.out.print(i+ ", ");
		        }
		    }
		    break;
		case 'b':
			System.out.println("Enter the number to test: ");
			int n2 = input.nextInt();
			boolean isPrime = TrialDivision.trialDivision(n2);
			if(isPrime)
				System.out.println(n2 + " is Prime");
			else
				System.out.println(n2 + " is not Prime");
			break;
		case 'c':
			System.out.println("Enter the first number: ");
			int a = input.nextInt();
			System.out.println("Enter the second number: ");
			int b = input.nextInt();
			int [] arr = ExtendedEuclidean.extendedEuclidean(a, b);
			System.out.println("GCD = " + arr[0]);
			System.out.println("Bezout’s coefficients : s = " +arr[1] + ",  t = "+ arr[2] );
		    System.out.println(arr[1] + "(" + a + ") + " + arr[2] + "(" + b + ") = " + arr[0]);
		    break;
		case 'd':
			System.out.println("Enter the number of integers: ");
			int k = input.nextInt();
			int[] mn = new int [k];
			int[] an = new int [k];
			System.out.println("Enter the array of the pairwire relativily primes: ");
			System.out.println("Space separated values works");
			for (int i=0;i<k;i++) {
				mn[i] = input.nextInt();
			}
			System.out.println("Enter the array of the remainders: ");
			System.out.println("Space separated values works");
			for (int i=0;i<k;i++) {
				an[i] = input.nextInt();
			}
			int x = ChineseRemainder.chineseRemainder(mn, an, k);
			System.out.println(x+" is the smallest positive integer");
			break;
		case 'e':
			System.out.println("Enter the number which you want to test: ");
			int s = input.nextInt();
			System.out.println("Enter the number of iterations: ");
			int q = input.nextInt();
			if (Miller_Test.isPrime(s, q)) 
	                System.out.print("'"+s+"'"+" is prime"); 
			else
				System.out.print("'"+s+"'"+" is not prime"); 
			
			break;
		}
		
		try {
			System.out.print("\n\n\n");
			System.out.print("=======================================================================");
			System.out.print("\n\n\n");
			input.reset();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}

import java.io.Console;

public class TrialDivision {
	
	
	public static boolean trialDivision(int n) {
		
		boolean [] primes = SieveOfEratosthenes.sieveOfEratosthenes( (int) Math.sqrt(n));
	    boolean isPrime = true;
		for (int i = 2; i< primes.length; i++) {
	    	if(primes[i]==true) {
	    		if (n%i==0)
	    			isPrime = false;
	        }
	    }

		return isPrime;

	}
}


public class SieveOfEratosthenes {

	public static boolean[] sieveOfEratosthenes(int limit)  {
	    boolean[] isPrime = new boolean[limit+1];
	    
	    //assume all numbers up to the limit are prime
	    for (int i = 0; i< limit; i++) {
	    	isPrime[i] = true;
	    }
	    
	    //start at 2 and up to Square root of the limit
	    for (int i = 2; i< Math.sqrt(limit); i++) {
	   
	    	if(isPrime[i] == true) {
	    		//starting i^2 and by adding i on each iteration
	    		// mark the digit at j as non prime
	    		//adding i to j on each iteration means that if i=2 
	    		//then all digits divisible by 2 are marked as non prime
	    		//note we start at 4 so values 1,2,3 will always be marked as prime
	    		for(int j = (i*i); j<limit; j = j+i) {
	    			isPrime[j] = false;
	    		}
	    	}
	    }
	    
	    return isPrime;
	}
}

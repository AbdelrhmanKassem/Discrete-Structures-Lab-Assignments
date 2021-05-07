
public class ChineseRemainder {
	public static int chineseRemainder (int[] mn , int[] an , int k ) {
		int m = 1;
		for (int n :mn) 
			m*=n;
		int x = 0;
		for (int i=0;i<k;i++) {
			int M = m/mn[i];
			x += an[i]*M*modInverse(M, mn[i]);
		}
		
		return x%m;
		
	}
	public static void main(String[] args) {
		int [] m = {3,5,7};
		int [] a = {2,3,2};
		System.out.print(chineseRemainder(m,a,3));
	}
	public static int modInverse(int a, int m) 
	{ 
	    int [] gcd = ExtendedEuclidean.extendedEuclidean(a, m); 
	    int g = gcd[0];
	    int x = gcd[1];
	    if (g != 1)
	    	//inverse doesn't exist
	        return -1;
	    else 
	    { 
	        int res = (x % m + m) % m; 
	        return res;
	    } 
	}	
	
}

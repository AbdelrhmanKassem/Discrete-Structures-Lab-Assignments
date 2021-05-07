
public class ExtendedEuclidean {
	public static int[] extendedEuclidean (int a, int b) {
		if (b == 0)
			return new int [] {a , 1 , 0};
		int [] arr = extendedEuclidean(b, a%b);
		int d = arr[0];
		int s = arr[2];
		int t = arr[1] - (a/b) * arr[2];
		return new int [] {d , s , t};
	}
	
	// to be used in Chinese remainder theorem
	

 
}

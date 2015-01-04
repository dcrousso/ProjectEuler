// https://projecteuler.net/problem=129
public class PE129 {
	public static void main(String[] args){
		int n = 1000001; // Must be greater than or equal to A(n)
		int k = 0;
		while(k <= 1000000) {
			n+=2;
			if(gcd(n, 10) == 1) { // n must be odd in order to prevent 2 as a common factor
				int x = 1;
	            k = 1;
	            while(x != 0) {
	                x = (x * 10 + 1) % n; // Long division using remainders
	                // Without using remainders, x quickly grows larger than the max value of Long
	                k++;
	            }
			}	
		}
		System.out.println(n);
	}
	public static int gcd(int n, int m) {
		if(m == 0) {
			return n;
		}
		return gcd(m, n % m);
	}
}
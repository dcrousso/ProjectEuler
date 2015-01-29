// https://projecteuler.net/problem=188
public class PE188 {
	public static void main(String[] args) {
		System.out.println(hyperexponentiation(1777, 1855, (long)Math.pow(10, 8)));
	}
	// Calculates the number of hyperexponentiations before n % mod > mod, leaving only 0s and 1s
	public static long numHyperexp(long n, long mod) {
		long num = n;
		long i = 1;
		while(num > 1) {
			num *= n;
			num %= mod;
			i++;
		}
		return i;
	}
	public static long hyperexponentiation(long n, long hyperexp, long mod) {
		// Continue recursing until the final exponent is reached
		if(hyperexp == 1) {
			return n % mod;
		}
		long nhe = numHyperexp(n, mod);
		long exp = hyperexponentiation(n, hyperexp - 1, nhe);
		long num = 1;
		for(long i = 0; i < exp; i++) {
			num *= n; // Hyperexponentiates num
			num %= mod; // Removes all irrelevant digits using mod
		}
		return num;
	}
}
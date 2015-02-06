// https://projecteuler.net/problem=231
public class PE231 {
	public static void main(String[] args) {
		// n = 20000000 and k = 15000000
		int[] smallestPrimeFactors = listSmallestPrimeFactors(20000001);
		long sum = primeFactorisationSum(20000000, smallestPrimeFactors);
			sum -= primeFactorisationSum(15000000, smallestPrimeFactors);
			sum -= primeFactorisationSum(5000000,  smallestPrimeFactors);
		System.out.println(sum);
	}
	public static long primeFactorisationSum(int n, int[] smallestPrimeFactors) {
		// Sums all the prime factors which divide into i
		long sum = 0;
		for(int i = 2; i <= n; i++) {
			int j = i;
			while(j > 1) {
				int p = smallestPrimeFactors[j];
				sum += p;
				j /= p;
			}
		}
		return sum;
	}
	public static int[] listSmallestPrimeFactors(int n) {
		// Modified Sieve of Eratosthenes
		int[] spf = new int[n];
		for(int i = 2; i < spf.length; i++) {
			if(spf[i] == 0) {
				for(int j = i; j < n; j += i) {
					if(spf[j] == 0) {
						spf[j] = i;
					}
				}
			}
		}
		return spf;
	}
}